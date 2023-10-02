package patterns.example.commands;

import patterns.example.entities.movie.Movie;
import patterns.example.storage.MovieStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindMovieByYear implements Command {
    int year;
    MovieStorage movieStorage = new MovieStorage();

    public FindMovieByYear(int year) {
        this.year = year;
    }

    @Override
    public void execute() {
        List<Movie> movieList = new ArrayList<>();
        try {
            movieList = movieStorage.getMovieList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        movieList = movieList.stream().filter(m -> m.getYear() == year).toList();
        movieList.forEach(System.out::println);
    }
}
