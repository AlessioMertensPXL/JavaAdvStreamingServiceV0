package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Account {
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private HashMap<String, Profile> profiles = new HashMap<>();

    public Account() {
        Profile profile = new Profile("profile1");
        //voorlopig basic streamingplan by default
        setStreamingPlan(StreamingPlan.BASIC);
        addProfile(profile);
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
        Profile profile = new Profile(email);
        //voorlopig basic streamingplan by default
        setStreamingPlan(StreamingPlan.BASIC);
        addProfile(profile);
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
        // vragen hoe dit effectief moet gebeuren, hashmaps hebben geen volgorde
        return getProfile("profile1");
    }

    public void addProfile(Profile profile) {
        if (profiles.size() < streamingPlan.getNumberOfProfiles()) {
            profiles.put(profile.getName(), profile);
        } else {
            throw new TooManyProfilesException();
        }

    }

    public Profile getProfile(String name){
        return profiles.get(name);
    }
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
