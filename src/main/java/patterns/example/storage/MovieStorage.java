package patterns.example.storage;

import com.fasterxml.jackson.databind.ObjectMapper;
import patterns.example.entities.movie.Movie;

import java.io.*;
import java.util.List;

public class MovieStorage {
    private final File movieFile = new File("C:\\files_temp\\movies.txt");
    ObjectMapper objectMapper = new ObjectMapper();

    public void addNewMovie(Movie movie) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(movieFile, true)) {
            objectMapper.writeValue(fileOut, movie);
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Movie> getMovieList() throws IOException {
        List<Movie> movieList = objectMapper.readValue(movieFile,
                objectMapper.getTypeFactory().constructCollectionType(List.class, Movie.class));
        return movieList;
    }
}
