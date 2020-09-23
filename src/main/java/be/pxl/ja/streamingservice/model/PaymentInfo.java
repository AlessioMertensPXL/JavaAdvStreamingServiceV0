package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class PaymentInfo {
    private String cardNumber;
    private CreditCardType type;
    private String firstName;
    private String lastName;
    private LocalDate expirationDate;
    private int securityCode;

    public PaymentInfo() {
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public CreditCardType getType() {
        return this.type;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public int getSecurityCode() {
        return this.securityCode;
    }
}
