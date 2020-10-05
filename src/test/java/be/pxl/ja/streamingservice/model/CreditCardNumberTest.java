package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditCardNumberTest {
    @Test
    void testExpectedException(){
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("One");
        });
    }
    @Test
    public void validVisaCard(){
        CreditCardNumber creditCardNumber = new CreditCardNumber("4123456789123456","123");
        assertEquals(CreditCardType.VISA,creditCardNumber.getType());
    }

    @Test
    public void validVisaCardWithBlanks(){
        CreditCardNumber creditCardNumber = new CreditCardNumber("41234 56789 1234 56   "," 1 2 3 ");
        assertEquals(CreditCardType.VISA,creditCardNumber.getType());
        assertEquals("123",creditCardNumber.getCvc());
        assertEquals("4123456789123456",creditCardNumber.getNumber());

    }

    @Test
    public void validMasterCardWith(){
        CreditCardNumber creditCardNumber = new CreditCardNumber("5123456789123456","123");
        assertEquals(CreditCardType.MASTERCARD,creditCardNumber.getType());
        assertEquals("123",creditCardNumber.getCvc());
        assertEquals("5123456789123456",creditCardNumber.getNumber());
    }

    @Test
    public void validMasterCardWithBlanks(){
        CreditCardNumber creditCardNumber = new CreditCardNumber("51234 56789 1234 56  "," 1 2 3");
        assertEquals(CreditCardType.MASTERCARD,creditCardNumber.getType());
        assertEquals("123",creditCardNumber.getCvc());
        assertEquals("5123456789123456",creditCardNumber.getNumber());
    }

    @Test
    public void throwsInvalidArgumentExceptionWhenNumberIsTooShort(){
        assertThrows(IllegalArgumentException.class, () -> {
           new CreditCardNumber("12345","123");
        });
    }

    @Test
    public void throwsInvalidArgumentExceptionWhenNumberIsTooLong(){
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditCardNumber("12345678912345678","123");
        });
    }

    @Test
    public void throwsInvalidArgumentExceptionWhenInvalidCardType(){
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditCardNumber("7123456789123456","123");
        });
    }

    @Test
    public void throwsInvalidArgumentExceptionWhenCvcIsTooLong(){
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditCardNumber("1234561234561234","1234");
        });
    }

    @Test
    public void throwsInvalidArgumentExceptionWhenCvcIsTooShort(){
        assertThrows(IllegalArgumentException.class, () -> {
            new CreditCardNumber("1234561234561234","12");
        });
    }

    @Test
    public void throwsInvalidArgumentExceptionWhenCvcIsNotNumeric(){
        assertThrows(IllegalArgumentException.class, () -> {
           new CreditCardNumber("1234561234561234","12B");
        });
    }

    @Test
    public void correctlyCreatesCreditCardWhenInfoIsCorrect(){
        CreditCardNumber creditCardNumber = new CreditCardNumber("4234567891234567","123");
        assertEquals(creditCardNumber.getNumber(),"4234567891234567");
        assertEquals(creditCardNumber.getCvc(),"123");
    }
}
