package patterns.example;

import patterns.example.commands.*;
import patterns.example.entities.movie.Movie;
import patterns.example.entities.movie.RegularMovie;

import java.util.Scanner;

public class Menu {
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isQuit = false;

//        System.out.println("Enter your full name:");
//        String customerName = scanner.nextLine();
        while (!isQuit) {
        System.out.println("""
                1 - All movies;
                2 - Add movie;
                3 - Find movie by title;
                4 - Find movies by year;
                0 - Exit;
                """);

            int number = scanner.nextInt();

            switch (number) {
                case 1 :
                    Command getAllMovies = new GetAllMoviesCommand();
                    getAllMovies.execute();
                    break;
                case 2 :
                    System.out.println("Enter the name, year, director: ");
                    String[] s = scanner.nextLine().split(", ");
                    Movie movie = new RegularMovie(s[0], Integer.parseInt(s[1]), s[2]);
                    Command addNewMovie = new AddNewMovieCommand(movie);
                    addNewMovie.execute();
                    break;
                case 3 :
                    System.out.println("Enter the title: ");
                    String title = scanner.nextLine();
                    Command findByTitle = new FindMovieByTitle(title);
                    findByTitle.execute();
                    break;
                case 4 :
                    System.out.println("Enter the year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    Command findByYear = new FindMovieByYear(year);
                    findByYear.execute();
                    break;
                case 0 :
                    isQuit = true;
                    break;
            }
        }
    }
}
