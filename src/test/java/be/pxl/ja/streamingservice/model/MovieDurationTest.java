package be.pxl.ja.streamingservice.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieDurationTest {
    private Movie movie = new Movie("Titanic",Rating.OLDER_KIDS);
    @Test
    public void negativeDurationBecomesPositive(){
        movie.setDuration(-125);
        assertEquals(125,movie.getDuration());
    }

    @Test
    public void positiveDurationStaysUnchanged(){
        movie.setDuration(125);
        assertEquals(125,movie.getDuration());
    }
}
