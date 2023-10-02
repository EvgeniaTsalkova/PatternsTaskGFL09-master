package patterns.example.commands;

import patterns.example.entities.movie.Movie;
import patterns.example.storage.MovieStorage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetAllMoviesCommand implements Command {
    private MovieStorage movieStorage = new MovieStorage();

    @Override
    public void execute() {
        List<Movie> movieList = new ArrayList<>();
        try {
            movieList = movieStorage.getMovieList();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        movieList.forEach(System.out::println);
    }
}
