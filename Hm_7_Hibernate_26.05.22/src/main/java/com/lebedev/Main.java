package com.lebedev;

import com.lebedev.dao.MovieDao;
import com.lebedev.entity.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieDao movieDao = new MovieDao();
//        Movie movie = movieDao.findById(222L).orElse(null);
//        System.out.println(movie);
////        movie.setTitle("new"+movie.getTitle());
////        Movie m1 = movieDao.updateMovie(movie);
////        System.out.println(m1);
//
//
//        Movie movie1 = new Movie();
//        movie1.setTitle("Начало1");
//        movie1.setDescription("2010 Кристофер Нолан боевик, мистический фильм, научная фантастика1");
//        movie1.setDuration(148);
//        Movie movie = movieDao.findById(2L).orElse(null);
//        movie.setDuration(125);
//        movieDao.save(movie);
        movieDao.deleteById(13L);
//
//        movieDao.save(movie1);
//        List<Movie> lm1 = movieDao.findAll();
////        List<Movie> lm2 = movieDao.findAll2();
//        lm1.forEach(System.out::println);


    }


}
