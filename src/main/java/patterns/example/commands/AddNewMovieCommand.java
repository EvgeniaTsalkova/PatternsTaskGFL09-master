package patterns.example.commands;

import patterns.example.entities.movie.Movie;
import patterns.example.storage.MovieStorage;

import java.io.IOException;

public class AddNewMovieCommand implements Command {
    private Movie movie;
    private MovieStorage movieStorage  = new MovieStorage();

    public AddNewMovieCommand(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void execute() {
        try {
//            List<Movie> movieList = movieStorage.getMovieList();
//            if (movieList == null) {
//                movieList = new ArrayList<>();
//            }
//            movieList.add(movie);
            movieStorage.addNewMovie(movie);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
