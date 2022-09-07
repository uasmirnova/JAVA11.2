package ru.netology.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTest {

    String movie1 = "Бладшот";
    String movie2 = "Вперед";
    String movie3 = "Отель Белград";
    String movie4 = "Джентльмены";
    String movie5 = "Человек-невидимка";
    String movie6 = "Тролли";

    @Test
    public void shouldAddMovies() {
        MovieManager manager = new MovieManager();

        manager.addMovies(movie1);
        manager.addMovies(movie2);
        manager.addMovies(movie3);
        manager.addMovies(movie4);
        manager.addMovies(movie5);
        manager.addMovies(movie6);

        String[] expected = { movie1, movie2, movie3, movie4, movie5, movie6 };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast5movies() {
        MovieManager manager = new MovieManager(5);

        manager.addMovies(movie1);
        manager.addMovies(movie2);
        manager.addMovies(movie3);
        manager.addMovies(movie4);
        manager.addMovies(movie5);

        String[] expected = { movie5, movie4, movie3, movie2, movie1 };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastDefault() {
        MovieManager manager = new MovieManager();

        manager.addMovies(movie1);
        manager.addMovies(movie2);
        manager.addMovies(movie3);
        manager.addMovies(movie4);
        manager.addMovies(movie5);
        manager.addMovies(movie6);

        String[] expected = { movie6, movie5, movie4, movie3, movie2, movie1 };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
