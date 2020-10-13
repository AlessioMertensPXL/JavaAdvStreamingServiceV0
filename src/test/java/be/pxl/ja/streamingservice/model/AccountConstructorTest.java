package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AccountConstructorTest {
    @Test
    public void ProfileMadeOnAccountCreationTest(){
        Account account = new Account();
        account.setStreamingPlan(StreamingPlan.PREMIUM);
        Profile profile1 = new Profile("test");
        Profile profile2 = new Profile("test1");
        Profile profile3 = new Profile("test2");
        Profile[] testprofiles = {profile1,profile2,profile3};
        for (Profile profile: testprofiles) {
            account.addProfile(profile);
        }
        assertEquals("profile1",account.getFirstProfile().getName());

    }
}
