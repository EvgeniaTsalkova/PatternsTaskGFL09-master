package patterns.example.entities.movie;

import patterns.example.entities.movie.Movie;

import java.io.Serializable;

public class NewReleaseMovie extends Movie implements Serializable {

    public NewReleaseMovie(String title, int year, String director) {
        super(title, year, director);
    }

    @Override
    public double calcRentalAmount(int daysRented) {
        return daysRented * 3;
    }
}
