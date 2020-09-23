package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles = new ArrayList();

    public Account() {
        Profile profile = new Profile("profile1");
        this.profiles.add(profile);
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile = new Profile(email);
        profile.setDateOfBirth(LocalDate.now());
        this.profiles.add(profile);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public String getEmail() {
        return this.email;
    }

    public Profile getFirstProfile() {
        return (Profile)this.profiles.get(0);
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
