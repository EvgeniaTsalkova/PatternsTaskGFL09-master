package patterns.example.entities;

import patterns.example.entities.movie.Movie;
import patterns.example.entities.movie.NewReleaseMovie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Customer implements Serializable {
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void rentMovie(Movie movie, int daysRented) {
        Rental rental = new Rental(movie, daysRented);
        rentals.add(rental);
    }

    public void returnMovie(Movie movie) {
        for (Rental rental : rentals) {
            if (rental.getMovie() == movie) {
                rentals.remove(movie);
            }
        }
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental each : rentals) {
            double thisAmount = 0;
            //determine amounts for each line
            thisAmount += each.getMovie().calcRentalAmount(each.getDaysRented());
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getClass().equals(NewReleaseMovie.class)) && each.getDaysRented() > 1)
                frequentRenterPoints++;
            //show figures for this rental
            result.append("\t").append(each.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points\n");
        return result.toString();
    }
}