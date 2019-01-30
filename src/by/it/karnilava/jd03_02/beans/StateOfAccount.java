package by.it.karnilava.jd03_02.beans;

public class StateOfAccount {
    private long idState;
    private String state;

    public StateOfAccount() {
    }

    public StateOfAccount(long idState, String state) {
        this.idState = idState;
        this.state = state;
    }

    public long getIdState() {
        return idState;
    }

    public void setIdState(long idState) {
        this.idState = idState;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "StateOfAccount{" +
                "idState=" + idState +
                ", state='" + state + '\'' +
                '}';
    }
}
