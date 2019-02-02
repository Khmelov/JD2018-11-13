package by.it.karnilava.jd03_03.beans;

public class State {
    private long id;
    private String state;

    public State() {
    }

    public State(long id, String state) {
        this.id = id;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "state{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
