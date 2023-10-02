package patterns.example.commands;

import patterns.example.entities.Customer;
import patterns.example.entities.movie.Movie;

public class ReturnMovieCommand implements Command {
    private Customer customer;
    private Movie movie;

    public ReturnMovieCommand(Customer customer, Movie movie) {
        this.customer = customer;
        this.movie = movie;
    }

    @Override
    public void execute() {
        customer.returnMovie(movie);
    }
}
