package ru.netology.movie;

public class MovieManager {

    private MovieRepository repo;

    public MovieManager(MovieRepository repo) {
        this.repo = repo;
    }

    public void add(MovieInfo movie) {
        repo.save(movie);
    }

    public MovieInfo[] findAll() {
        MovieInfo[] all = repo.findAll();
        return all;
    }

    public MovieInfo[] findById(int id) {
        MovieInfo[] result = repo.findById(id);
        return result;
    }

    public MovieInfo[] removeById(int id) {
        repo.removeById(id);
        return new MovieInfo[0];
    }

    public void removeAll() {
        repo.removeAll();
    }
}
