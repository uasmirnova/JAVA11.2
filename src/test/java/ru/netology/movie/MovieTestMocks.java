package ru.netology.movie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class MovieTestMocks {

    MovieRepository repo = Mockito.mock(MovieRepository.class);
    MovieManager manager = new MovieManager(repo);

    MovieInfo movie1 = new MovieInfo(1, "Бладшот");
    MovieInfo movie2 = new MovieInfo(2, "Вперед");
    MovieInfo movie3 = new MovieInfo(3, "Отель Белград");
    MovieInfo movie4 = new MovieInfo(4, "Джентльмены");
    MovieInfo movie5 = new MovieInfo(5, "Человек-невидимка");

    @Test
    public void shouldRemoveAll() {

        MovieInfo[] movies = new MovieInfo[0];
        doReturn(movies).when(repo).findAll();

        MovieInfo[] expected = new MovieInfo[0];
        MovieInfo[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldRemoveById() {

        MovieInfo[] movies = { movie1, movie2, movie4, movie5 };
        doReturn(movies).when(repo).findAll();

        int id = 3;
        manager.removeById(id);

        MovieInfo[] expected = { movie1, movie2, movie4, movie5 };
        MovieInfo[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
