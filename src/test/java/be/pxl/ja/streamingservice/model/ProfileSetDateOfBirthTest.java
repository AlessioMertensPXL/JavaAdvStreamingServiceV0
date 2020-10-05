package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
public class ProfileSetDateOfBirthTest {
    @Test
    public void setDateOfBirthThrowsExceptionWhenInFuture(){
        assertThrows(InvalidDateException.class, () -> {
            new Profile("name", LocalDate.now().plusDays(1));
        });
    }
}
