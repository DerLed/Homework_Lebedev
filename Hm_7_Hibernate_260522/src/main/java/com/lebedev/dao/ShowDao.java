package com.lebedev.dao;

import com.lebedev.entity.*;
import com.lebedev.entity.Genre_;
import com.lebedev.entity.Movie_;
import com.lebedev.entity.Show_;
import com.lebedev.util.EmfUtil;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;

public class ShowDao {

    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

    public List<Show> findAll(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT s from Show s", Show.class).getResultList();
    }

    public Optional<Show> findById(Long id){
        EntityManager em = emf.createEntityManager();
        EntityGraph<?> entityGraph = em.getEntityGraph("show-entity-graph");
        Map<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", entityGraph);
        Show show = em.find(Show.class, id, properties);
        return Optional.ofNullable(show);
    }

    public Show save(Show show) {
        EntityManager em = emf.createEntityManager();
        Show newInstance;
        em.getTransaction().begin();
        if (show.getId() == null) {
            em.persist(show);
            newInstance = show;
        } else {
            newInstance = em.merge(show);
        }
        em.getTransaction().commit();
        return newInstance;
    }

    public List<Show> findByDate(LocalDate date){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Show> qr = cb.createQuery(Show.class);
        Root<Show> root = qr.from(Show.class);
        root.fetch(Show_.movie).fetch(Movie_.genres, JoinType.LEFT);
        Predicate p = cb.between(root.get(Show_.timeStart), date.atStartOfDay(), date.atStartOfDay().plusDays(1L));
        qr.where(p);
        return em.createQuery(qr).getResultList();
    }

    public List<Show> findByGenre(String genreName){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Show> qr = cb.createQuery(Show.class);
        Root<Show> root = qr.from(Show.class);
        Join<Movie, Genre> j = root.join(Show_.movie).join(Movie_.genres);
        root.fetch(Show_.movie).fetch(Movie_.genres, JoinType.LEFT);
        Predicate p = cb.like(cb.lower(j.get(Genre_.name)), "%"+ genreName.toLowerCase(Locale.ROOT)+"%");
        qr.where(p);
        qr.distinct(true);
        return em.createQuery(qr).getResultList();
    }

}
