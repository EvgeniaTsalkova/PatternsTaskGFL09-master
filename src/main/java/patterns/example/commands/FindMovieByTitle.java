package patterns.example.commands;

import patterns.example.entities.movie.Movie;
import patterns.example.storage.MovieStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindMovieByTitle implements Command {
    String findBy;
    MovieStorage movieStorage = new MovieStorage();

    public FindMovieByTitle(String findBy) {
        this.findBy = findBy;
    }

    @Override
    public void execute() {
        List<Movie> movieList = new ArrayList<>();
        try {
            movieList = movieStorage.getMovieList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        movieList = movieList.stream().filter(m -> Objects.equals(m.getTitle(), findBy)).toList();
        movieList.forEach(System.out::println);
    }
}
