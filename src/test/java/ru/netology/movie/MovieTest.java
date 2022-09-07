package ru.netology.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {

    MovieRepository repo = new MovieRepository();
    MovieManager manager = new MovieManager(repo);

    MovieInfo movie1 = new MovieInfo(1, "Бладшот");
    MovieInfo movie2 = new MovieInfo(2, "Вперед");
    MovieInfo movie3 = new MovieInfo(3, "Отель Белград");
    MovieInfo movie4 = new MovieInfo(4, "Джентльмены");
    MovieInfo movie5 = new MovieInfo(5, "Человек-невидимка");

    @BeforeEach
    public void setUp() {
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
    }

    @Test
    public void ShouldFindAll() {

        MovieInfo[] expected = { movie1, movie2, movie3, movie4, movie5 };
        MovieInfo[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindId() {

        int id = 5;

        MovieInfo[] expected = { movie5 };
        MovieInfo[] actual = manager.findById(id);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldFindIdNon() {

        int id = 6;

        MovieInfo[] expected = { null };
        MovieInfo[] actual = manager.findById(id);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveById() {

        int id = 3;
        manager.removeById(id);

        MovieInfo[] expected = { movie1, movie2, movie4, movie5 };
        MovieInfo[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveAll() {

        manager.removeAll();

        MovieInfo[] expected = new MovieInfo[0];
        MovieInfo[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
