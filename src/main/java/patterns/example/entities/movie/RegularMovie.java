package patterns.example.entities.movie;

import java.io.Serializable;

public class RegularMovie extends Movie implements Serializable {

    public RegularMovie(String title, int year, String director) {
        super(title, year, director);
    }

    @Override
    public double calcRentalAmount(int daysRented) {
        double amount = 2;
        if (daysRented > 2)
            amount += (daysRented - 2) * 1.5;
        return amount;
    }
}
