package by.it.karnilava.project05.java.beans;

public class Account {
    private long id;
    private String number;
    private String balance;
    private long idClient;
    private long idType;
    private long idState;

    public Account() {
    }

    public Account(long idAccount, String numberOfAccount, String balance, long idClient, long idType, long idState) {
        this.id = idAccount;
        this.number = numberOfAccount;
        this.balance = balance;
        this.idClient = idClient;
        this.idType = idType;
        this.idState = idState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public long getIdType() {
        return idType;
    }

    public void setIdType(long idType) {
        this.idType = idType;
    }

    public long getIdState() {
        return idState;
    }

    public void setIdState(long idState) {
        this.idState = idState;
    }

    @Override
    public String toString() {
        return "account{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance='" + balance + '\'' +
                ", idClient=" + idClient +
                ", idType=" + idType +
                ", idState=" + idState +
                '}';
    }
}


