package by.it.karnilava.jd03_02.beans;

public class Account {
    private long idAccount;
    private String numberOfAccount;
    private String balance;
    private long idClient;
    private long idType;
    private long idState;

    public Account() {
    }

    public Account(long idAccount, String numberOfAccount, String balance, long idClient, long idType, long idState) {
        this.idAccount = idAccount;
        this.numberOfAccount = numberOfAccount;
        this.balance = balance;
        this.idClient = idClient;
        this.idType = idType;
        this.idState = idState;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public String getNumberOfAccount() {
        return numberOfAccount;
    }

    public void setNumberOfAccount(String numberOfAccount) {
        this.numberOfAccount = numberOfAccount;
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
        return "Account{" +
                "idAccount=" + idAccount +
                ", numberOfAccount='" + numberOfAccount + '\'' +
                ", balance='" + balance + '\'' +
                ", idClient=" + idClient +
                ", idType=" + idType +
                ", idState=" + idState +
                '}';
    }
}


