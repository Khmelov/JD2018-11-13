package by.it.nickgrudnitsky.jd03_03.beans;

public class Followings {
    private long viewers_id;
    private long streamers_id;

    public Followings(long viewers_id, long streamers_id) {
        this.viewers_id = viewers_id;
        this.streamers_id = streamers_id;
    }

    public Followings() {
    }

    public long getViewers_id() {
        return viewers_id;
    }

    public void setViewers_id(long viewers_id) {
        this.viewers_id = viewers_id;
    }

    public long getStreamers_id() {
        return streamers_id;
    }

    public void setStreamers_id(long streamers_id) {
        this.streamers_id = streamers_id;
    }

    @Override
    public String toString() {
        return "Followings{" +
                "viewers_id=" + viewers_id +
                ", streamers_id=" + streamers_id +
                '}';
    }
}
