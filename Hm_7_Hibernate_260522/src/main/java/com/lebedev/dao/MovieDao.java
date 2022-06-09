package com.lebedev.dao;

import com.lebedev.entity.Genre;
import com.lebedev.entity.Genre_;
import com.lebedev.entity.Movie;
import com.lebedev.entity.Movie_;
import com.lebedev.exception.MovieNotFoundException;
import com.lebedev.util.EmfUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Locale;
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

    public void deleteById(Long id){
        EntityManager em = emf.createEntityManager();
        Movie deleteMovie = em.find(Movie.class, id);
        em.getTransaction().begin();
            em.remove(deleteMovie);
        em.getTransaction().commit();
    }

    public List<Movie> findMovieByGenre(String genreName){
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Movie> qr = cb.createQuery(Movie.class);
        Root<Movie> root = qr.from(Movie.class);
        Join<Movie, Genre> j = root.join(Movie_.genres);
        root.fetch(Movie_.genres);
        Predicate p = cb.like(cb.lower(j.get(Genre_.name)), "%"+ genreName.toLowerCase(Locale.ROOT)+"%");
        qr.where(p);
        qr.distinct(true);
        return em.createQuery(qr).getResultList();
    }

    //такой метод скорее всего избыточен но оставил его
    public Movie setGenre(Movie movie, Genre genre){
        EntityManager em = emf.createEntityManager();
        Movie newInstance;
        em.getTransaction().begin();
        if (movie.getId() == null) {
            throw new MovieNotFoundException();
        } else {
            movie.setGenre(genre);
            newInstance = em.merge(movie);
        }
        em.getTransaction().commit();
        return newInstance;
    }

}