package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends Content implements Playable {
    public static final int LONG_PLAYING_TIME = 135;
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;
    private StringBuilder stringBuilder = new StringBuilder();

    public Movie(String title, Rating maturityRating) {
        super(title, maturityRating);
    }

    public String getDirector() {
        return this.director;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlayingTime() {
        int duration = this.duration;
        if (duration == 0) {
            return "?";
        } else {
            int hours = duration / 60;
            int minutes = duration % 60;
            if (hours > 0) {
                this.stringBuilder.append(String.format("%s h", hours));
            }

            if (minutes > 0) {
                this.stringBuilder.append(String.format(" %s min", minutes));
            }

            String result = this.stringBuilder.toString().trim();
            this.stringBuilder.delete(0, this.stringBuilder.length());
            return result;
        }
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setDuration(int duration) {
        this.duration = Math.abs(duration);
    }

    public String toString() {
        if (this.getReleaseDate() != null) {
            String var10000 = super.getTitle();
            return var10000 + " " + this.getReleaseDate().getYear();
        } else {
            return super.getTitle();
        }
    }

    public void play() {
        System.out.println("playing " + this);
    }

    public void pause() {
        System.out.println("pausing " + this);
    }

    public boolean isLongPlayingTime() {
        return this.duration >= 135;
    }
}
