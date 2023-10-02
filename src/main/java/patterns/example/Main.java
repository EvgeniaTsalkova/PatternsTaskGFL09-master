package patterns.example;

import patterns.example.commands.*;
import patterns.example.entities.Customer;
import patterns.example.entities.movie.ChildrensMovie;
import patterns.example.entities.movie.Movie;
import patterns.example.entities.movie.NewReleaseMovie;
import patterns.example.entities.movie.RegularMovie;


public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();

        Movie movie1 = new RegularMovie("Rambo", 1982, "Ted Kotcheff");
        Movie movie2 = new NewReleaseMovie("Lord of the Rings", 2001, "Peter Jackson");
        Movie movie3 = new ChildrensMovie("Harry Potter", 2001, "Chris Columbus");

        Customer customer = new Customer("John Doe");

        Command addNewMovie1 = new AddNewMovieCommand(movie1);
        Command addNewMovie2 = new AddNewMovieCommand(movie2);
        Command addNewMovie3 = new AddNewMovieCommand(movie3);

        addNewMovie1.execute();
        addNewMovie2.execute();
        addNewMovie3.execute();

        Command rentMovie1 = new RentMovieCommand(customer, movie1, 1);
        Command rentMovie2 = new RentMovieCommand(customer, movie2, 4);
        Command rentMovie3 = new RentMovieCommand(customer, movie3, 5);

        rentMovie1.execute();
        rentMovie2.execute();
        rentMovie3.execute();

        Command getMovies = new GetAllMoviesCommand();
        getMovies.execute();

        Command addNewCustomer = new AddNewCustomer(customer);
        addNewCustomer.execute();

        menu.showMenu();

        System.out.println(customer.statement());
    }
}