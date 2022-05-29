package com.lebedev.dao;

import com.lebedev.entity.Genre;
import com.lebedev.entity.Movie;
import com.lebedev.util.EmfUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class GenreDao {

    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

    public Optional<Genre> findById(Long id){
        EntityManager em = emf.createEntityManager();
        Genre findGenre = em.find(Genre.class, id);
        return Optional.ofNullable(findGenre);
    }

    public List<Movie> findAll(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT g from Genre g", Movie.class).getResultList();
    }
}
