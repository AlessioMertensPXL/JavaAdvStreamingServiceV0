package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ProfileWatchingContentTest {
    private Profile profile;
    @BeforeEach
    public void init() {
        profile = new Profile("name");
    }



    @Test
    public void startWatchingAddsContentToStartOfTheRecentlyWatchedCollection(){
        Content movie = new Movie("name", Rating.MATURE);
        Content movie2 = new Movie("movie2",Rating.TEENS);
        profile.startWatching(movie);
        profile.startWatching(movie2);
        assertEquals(profile.getRecentlyWatched().getFirst(),movie2);

    }
    @Test
    public void recentlyWatchedDoesNotHaveDuplicates(){
        Content movie = new Movie("name", Rating.MATURE);
        profile.startWatching(movie);
        profile.startWatching(movie);
        assertEquals(profile.getRecentlyWatched().toArray().length,1);
    }

    @Test
    public void finishedWatchingAddsContentToRecentlyWatched(){
        Content movie = new Movie("name", Rating.MATURE);
        Content movie2 = new Movie("movie2",Rating.TEENS);
        profile.startWatching(movie2);
        profile.finishedWatching(movie);
        assertEquals(profile.getRecentlyWatched().getFirst(),movie);
        profile.finishedWatching(movie2);
        assertEquals(profile.getRecentlyWatched().getFirst(),movie2);
    }

    @Test
    public void finishedWatchingRemovesContentFromCurrentlyWatching(){
        Content movie2 = new Movie("movie2",Rating.TEENS);
        profile.startWatching(movie2);
        profile.finishedWatching(movie2);
        assertFalse(profile.getCurrentlyWatching().contains(movie2));
    }
}
