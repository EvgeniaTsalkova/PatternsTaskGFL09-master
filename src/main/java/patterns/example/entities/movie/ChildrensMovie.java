package patterns.example.entities.movie;

import java.io.Serializable;

public class ChildrensMovie extends Movie implements Serializable {

    public ChildrensMovie(String title, int year, String director) {
        super(title, year, director);
    }

    @Override
    public double calcRentalAmount(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}
