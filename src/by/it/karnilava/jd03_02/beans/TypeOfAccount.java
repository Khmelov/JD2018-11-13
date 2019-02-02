package by.it.karnilava.jd03_02.beans;

public class TypeOfAccount {
    private long idType_of_account;
    private String type;

    public TypeOfAccount() {
    }

    public TypeOfAccount(long idType_of_account, String type) {
        this.idType_of_account = idType_of_account;
        this.type = type;
    }

    public long getIdType_of_account() {
        return idType_of_account;
    }

    public void setIdType_of_account(long idType_of_account) {
        this.idType_of_account = idType_of_account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeOfAccount{" +
                "idType_of_account=" + idType_of_account +
                ", type='" + type + '\'' +
                '}';
    }
}

