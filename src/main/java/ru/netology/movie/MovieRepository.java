package ru.netology.movie;

public class MovieRepository {

    private MovieInfo[] movies = new MovieInfo[0];

    public MovieInfo[] findAll() {
        return movies;
    }

    public void save(MovieInfo movie) {
        MovieInfo[] tmp = new MovieInfo[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieInfo[] findById(int id) {
        MovieInfo[] result = new MovieInfo[1];
        for (MovieInfo movie : movies) {
            if (movie.getId() == id) {
                result[0] = movie;
            }
        }
        return result;
    }

    public void removeById(int id) {
        MovieInfo[] tmp = new MovieInfo[movies.length - 1];
        int copyToIndex = 0;
        for (MovieInfo movie : movies) {
            if (movie.getId() != id) {
                tmp[copyToIndex] = movie;
                copyToIndex++;
            }
        }
        movies = tmp;
    }

    public void removeAll() {
        MovieInfo[] tmp = new MovieInfo[0];
        movies = tmp;
    }
}
