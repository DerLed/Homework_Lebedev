package com.lebedev;

import com.lebedev.dao.GenreDao;
import com.lebedev.dao.MovieDao;
import com.lebedev.dao.ShowDao;
import com.lebedev.entity.Movie;
import com.lebedev.entity.Show;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieDao movieDao = new MovieDao();
        GenreDao genreDao = new GenreDao();
        ShowDao showDao = new ShowDao();

        //Поиск фильма по id
        Movie movie = movieDao.findById(8L).orElseThrow();
        System.out.println(movie.getTitle());

        //Обновление фильма
        movie.setTitle("new" + movie.getTitle());
        movie.setGenre(genreDao.findById(3L).orElseThrow());
        Movie updatedMovie = movieDao.save(movie);
        System.out.println(updatedMovie.getTitle());
        updatedMovie.getGenres().forEach(System.out::println);

        //Добавление фильма
        Movie newMovie = new Movie();
        newMovie.setTitle("Начало");
        newMovie.setDescription("год: 2010, режисер: Кристофер Нолан, в главной роли Леонардо Ди Каприо");
        newMovie.setDuration(148);
        newMovie.setGenre(genreDao.findById(29L).orElseThrow());
        Movie savedMovie = movieDao.save(newMovie);

        //Добавление сеанса показа фильма
        Show newShow = new Show();
        newShow.setTimeStart(LocalDateTime.of(2022, 5, 31, 12, 0));
        newShow.setMovie(savedMovie);
        showDao.save(newShow);

        //Поиск по дате сеанса, всех фильмов в данную дату
        List<Show> ls = showDao.findByDate(LocalDate.of(2022, 5, 31));
        ls.forEach(System.out::println);

    }
}
