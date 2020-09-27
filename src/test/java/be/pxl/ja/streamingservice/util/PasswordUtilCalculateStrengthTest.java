package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordUtilCalculateStrengthTest {
    @Test
    public void PasswordStrengthMatchesConditions() {
        StringBuilder password = new StringBuilder();
        password.append("aaa");
        assertEquals(PasswordUtil.calculateStrength(password.toString()), 0);
        password.append("aaa");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - 2, 1);
        password.append("aaaaaaaaa");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - 2, 2);
        password.delete(0, password.length());
        password.append("123456");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - 1, 2);
        password.delete(0, password.length());
        password.append("DDDDDD");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - 1, 2);
        password.delete(0, password.length());
        password.append("~!@#$%");
        assertEquals(PasswordUtil.calculateStrength(password.toString()) - 1, 2);
    }
}
