package be.pxl.ja.streamingservice.util;

public class PasswordUtil {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";


    public static int calculateStrength(String password) {
        int score = 0;
        if (password.length() < 6) {
            return 0;
        }
        if (password.length() < 10) {
            score += 1;
        } else {
            score += 2;
        }
        score += passwordContainsDigit(password) + passwordContainsLowerCase(password) + passwordContainsUpperCase(password) + passwordContainsSpecialChar(password);


        return score;
    }

    private static int passwordContainsDigit(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return 2;
            }
        }
        return 0;
    }

    private static int passwordContainsLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return 2;
            }
        }
        return 0;
    }

    private static int passwordContainsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return 2;
            }
        }
        return 0;
    }

    private static int passwordContainsSpecialChar(String password) {
        for (int i = 0; i < password.length(); i++) {
            for (int j = 0; j < SPECIAL_CHARACTERS.length(); j++) {
                if (password.charAt(i) == SPECIAL_CHARACTERS.charAt(j)) {
                    return 2;
                }
            }
        }
        return 0;
    }
}
