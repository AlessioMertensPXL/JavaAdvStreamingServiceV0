package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Profile {
    private String name;
    private LocalDate dateOfBirth;
    private HashSet<Content> currentlyWatching;
    private ArrayDeque<Content> recentlyWatched;

    public Profile(String name, LocalDate dateOfBirth) {
        setName(name);
        setDateOfBirth(dateOfBirth);
        currentlyWatching = new HashSet<>();
        recentlyWatched = new ArrayDeque<>();
    }

    public Profile(String name) {
        this.setName(name);
        currentlyWatching = new HashSet<>();
        recentlyWatched = new ArrayDeque<>();
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
        if (dateOfBirth.isAfter(LocalDate.now())){
            throw new InvalidDateException(dateOfBirth,"birthDate","Birthday can not be in the future");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        if (this.dateOfBirth == null){
            return 0;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

    public HashSet<Content> getCurrentlyWatching() {
        return currentlyWatching;
    }

    public ArrayDeque<Content> getRecentlyWatched() {
        return recentlyWatched;
    }

    public boolean allowedToWatch(Content content) {
        return content.getMaturityRating().getMinimumAge() < this.getAge();
    }

    public void startWatching(Content content){
        recentlyWatched.remove(content);
        recentlyWatched.addFirst(content);
        currentlyWatching.add(content);
    }

    public void finishedWatching(Content content){
        recentlyWatched.remove(content);
        recentlyWatched.addFirst(content);
        currentlyWatching.remove(content);
    }
}
