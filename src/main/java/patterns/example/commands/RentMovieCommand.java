package patterns.example.commands;

import patterns.example.entities.Customer;
import patterns.example.entities.movie.Movie;

public class RentMovieCommand implements Command {
    private Customer customer;
    private Movie movie;
    private int daysRented;

    public RentMovieCommand(Customer customer, Movie movie, int daysRented) {
        this.customer = customer;
        this.movie = movie;
        this.daysRented = daysRented;
    }

    @Override
    public void execute() {
        customer.rentMovie(movie, daysRented);
    }
}
