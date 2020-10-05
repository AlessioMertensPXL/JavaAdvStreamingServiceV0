package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
public class ProfileAgeTest {
    @Test
    void itShouldSetCorrectAgeWhenSettingBirthdate(){
        // arrange
        Profile profile = new Profile("test profile");
        //act
        profile.setDateOfBirth(LocalDate.of(1979,12,13));
        // assert
        assertTrue(profile.getAge()==40);
    }

    @Test
    void shouldBeAllowedToWatch(){

        Profile profile = new Profile("test");
        profile.setDateOfBirth(LocalDate.of(1900,1,1));
        Content tvShow = new TVShow("test",Rating.MATURE,2);
        assertTrue(profile.allowedToWatch(tvShow));
    }
}
