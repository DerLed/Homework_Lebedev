package com.lebedev.dao;

import com.lebedev.entity.Movie;
import com.lebedev.util.EmfUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class MovieDao {

    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

    public Optional<Movie> findById(Long id){
        EntityManager em = emf.createEntityManager();
        Movie findMovie = em.find(Movie.class, id);
        return Optional.ofNullable(findMovie);
    }

    public List<Movie> findAll(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT m from Movie m", Movie.class).getResultList();
    }

    public List<Movie> findAll2(){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Movie> q = cb.createQuery(Movie.class);
        Root<Movie> root = q.from(Movie.class);
        q.select(root);
        return em.createQuery(q).getResultList();
    }

    public Movie save(Movie movie) {
        EntityManager em = emf.createEntityManager();
        Movie newInstance;
        em.getTransaction().begin();
        if (movie.getId() == null) {
            em.persist(movie);
            newInstance = movie;
        } else {
            newInstance = em.merge(movie);
        }
        em.getTransaction().commit();
        return newInstance;
    }

    public Movie updateMovie(Movie movie) {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaUpdate<Movie> criteriaUpdate = cb.createCriteriaUpdate(Movie.class);
        Root<Movie> root = criteriaUpdate.from(Movie.class);
        criteriaUpdate.set("title", movie.getTitle());
        criteriaUpdate.set("title", movie.getTitle());
        criteriaUpdate.where(cb.equal(root.get("itemPrice"), oldPrice));

        Transaction transaction = session.beginTransaction();
        session.createQuery(criteriaUpdate).executeUpdate();
        transaction.commit();

        Movie newInstance;
        em.getTransaction().begin();
        if (movie.getId() == null) {
            em.persist(movie);
            newInstance = movie;
        } else {
            newInstance = em.merge(movie);
        }
        em.getTransaction().commit();
        return newInstance;
    }


}
