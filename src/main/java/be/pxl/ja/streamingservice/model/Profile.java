package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.Period;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;

    public Profile(String name, LocalDate dateOfBirth) {
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
    }

    public Profile(String name) {
        this.setName(name);
        // default datum (moet mogenlijk later aangepast worden):
        //this.setDateOfBirth(LocalDate.now());
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        if (this.dateOfBirth == null){
            return 0;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public boolean allowedToWatch(Content content) {
        return content.getMaturityRating().getMinimumAge() < this.getAge();
    }
}
