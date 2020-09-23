package be.pxl.ja.streamingservice.model;

public enum Rating {
    LITTLE_KIDS(6),
    OLDER_KIDS(7),
    TEENS(12),
    MATURE(16);

    private int minimumAge;

    Rating(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public int getMinimumAge() {
        return this.minimumAge;
    }
}
