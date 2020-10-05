package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DocumentaryTest {
    @Test
    public void testDocumentaryConstructor(){
        Documentary documentary = new Documentary("planet earth",Rating.OLDER_KIDS);
        assertEquals("planet earth",documentary.getTitle());
        assertEquals(Rating.OLDER_KIDS,documentary.getMaturityRating());
        assertEquals(Genre.DOCUMENTARY,documentary.getGenre());
    }
}
