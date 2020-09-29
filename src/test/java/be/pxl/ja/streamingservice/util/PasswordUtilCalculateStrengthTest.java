package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordUtilCalculateStrengthTest {
    @Test
    public void PasswordStrengthMatchesConditions() {
        int lengthBasedStrength = 1;
        int lowerCaseBasedStrength = 2;
        StringBuilder password = new StringBuilder();
        password.append("aaa");
        assertEquals(PasswordUtil.calculateStrength(password.toString()), 0);
        password.append("aaa");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - lowerCaseBasedStrength, 1);
        password.append("aaaaaaaaa");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - lowerCaseBasedStrength, 2);
        password.delete(0, password.length());
        password.append("123456");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - lengthBasedStrength, 2);
        password.delete(0, password.length());
        password.append("DDDDDD");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - lengthBasedStrength, 2);
        password.delete(0, password.length());
        password.append("~!@#$%");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - lengthBasedStrength, 2);
    }
}
