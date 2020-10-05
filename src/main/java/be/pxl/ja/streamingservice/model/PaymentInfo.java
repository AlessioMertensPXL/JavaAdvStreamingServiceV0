package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class PaymentInfo {
    private CreditCardNumber cardNumber;
    private String firstName;
    private String lastName;
    private LocalDate expirationDate;


    public PaymentInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        if (LocalDate.now().plusMonths(1).isAfter(expirationDate)){
            throw new InvalidDateException(expirationDate,"expirationDate","Must be valid for at least 1 month.");
        }
        this.expirationDate = expirationDate;
    }
}
