package ru.netology.movie;

public class MovieManager {

    private String[] movies = new String[0];
    private int numberOfFilms = 10;

    public MovieManager() {

    }

    public MovieManager(int numberOfFilms) {
        this.numberOfFilms = numberOfFilms;
    }

    public void addMovies(String movie) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength;
        if (numberOfFilms < movies.length) {
            resultLength = numberOfFilms;
        } else {
            resultLength = movies.length;
        }

        String[] result = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[resultLength - 1 - i];
        }
        movies = result;
        return movies;
    }
}
