package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProfileAllowedToWatchContentTest {
    private Rating[] rating = Rating.values();
    private Profile profile;
    private Content content;
    @BeforeEach
    public void init(){
        profile = new Profile("name", LocalDate.now());
    }



    @Test
    public void ReturnsTrueIfIsAllowedToWatch() {

        for (var item : rating) {
            profile.setDateOfBirth(LocalDate.of(LocalDate.now().getYear() - item.getMinimumAge() - 1, 1, 1));
            content = new Movie("name", item);
            assertTrue(profile.allowedToWatch(content));

        }
    }

    @Test
    public void ReturnsFalseIfNotAllowedToWatch() {
        profile.setDateOfBirth(LocalDate.now());
        for (var item : rating){
            content = new Movie("name",item);
            assertFalse(profile.allowedToWatch(content));
        }
    }


}
