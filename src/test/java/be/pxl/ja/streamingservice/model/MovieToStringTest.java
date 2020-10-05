package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieToStringTest {
    private Movie movie;

    @BeforeEach
    public void init(){

        movie = new Movie("titanic",Rating.OLDER_KIDS);
    }

    @Test
    public void ReturnsYearWhenValueIsPresent(){

        movie.setReleaseDate(LocalDate.of(2000,5,20));
        assertEquals(movie.toString(), String.format("%s %s",movie.getTitle(),movie.getReleaseDate().getYear()));
    }

    @Test
    public void DoesNotReturnYearWhenValueIsAbsent(){
        assertEquals(movie.toString(),movie.getTitle());
    }
}
