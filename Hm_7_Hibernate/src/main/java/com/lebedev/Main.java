package com.lebedev;

import com.lebedev.dao.MovieDao;
import com.lebedev.entity.Movie;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.findById(2L).orElse(null);
        System.out.println(movie);

        Movie movie1 = new Movie();
        movie1.setTitle("Начало");
        movie1.setDescription("2010 Кристофер Нолан боевик, мистический фильм, научная фантастика");
        movie1.setDuration(148);

        movieDao.save(movie1);

        List<Movie> lm = movieDao.findAll();
        lm.forEach(System.out::println);


    }


}
