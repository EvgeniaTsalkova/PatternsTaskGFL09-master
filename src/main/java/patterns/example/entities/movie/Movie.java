package patterns.example.entities.movie;

import java.io.Serializable;

public abstract class Movie implements Serializable {
    private final String title;
    private final int year;
    private final String director;

    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    public abstract double calcRentalAmount(int daysRented);

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", director='" + director + '\'' +
                '}';
    }
}