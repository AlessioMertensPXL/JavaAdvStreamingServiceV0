package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountProfilesTest {
    private Account account;

    @BeforeEach
    public void init() {
        account = new Account();

    }

    @Test
    public void addProfileAddsAccountsWhenSlotsAreAvailable() {
        account.setStreamingPlan(StreamingPlan.PREMIUM);
        Profile profile = new Profile("name");
        account.addProfile(profile);
        assertEquals(profile, account.getProfile(profile.getName()));
    }

    @Test
    public void addProfileThrowsExceptionWhenSlotsAreUnavailable() {
        Profile profile = new Profile("name");
        assertThrows(TooManyProfilesException.class, () ->{
            account.addProfile(profile);
        });
    }

}
