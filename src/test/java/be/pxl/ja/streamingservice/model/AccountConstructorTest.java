package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class AccountConstructorTest {
    @Test
    public void ProfileMadeOnAccountCreationTest(){
        Account account = new Account();
        assertEquals(account.getFirstProfile().getName(),"profile1");

    }
}
