package be.pxl.ja.streamingservice.model;

public class Documentary extends Movie {
    private String topic;

    public Documentary(String title, Rating rating) {
        super(title, rating);
        super.setGenre(Genre.DOCUMENTARY);
        this.setTopic(this.topic);
    }

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void play() {
        System.out.println("playing " + this.topic);
    }

    public void pause() {
        System.out.println("pausing " + this.topic);
    }
}

