package by.it.karnilava.jd03_03.beans;

public class Client {
    private  long id;
    private String passport;
    private String firstName;
    private String lastName;
    private String password;
    private long idRoles;

    public Client() {
    }

    public Client(long id, String passport, String firstName, String lastName, String password, long idRoles) {
        this.id = id;
        this.passport = passport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.idRoles = idRoles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getIdRoles() {
        return idRoles;
    }

    public void setIdRoles(long idRoles) {
        this.idRoles = idRoles;
    }

    @Override
    public String toString() {
        return "client{" +
                "id=" + id +
                ", passport='" + passport + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", idRoles=" + idRoles +
                '}';
    }
}


