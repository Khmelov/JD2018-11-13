package by.it.karnilava.jd03_02.beans;

public class Client {
    private  long idClient;
    private String ID_passport;
    private String firstName;
    private String lastName;
    private String password;
    private long roles_idRoles;

    public Client() {
    }

    public Client(long idClient, String ID_passport, String firstName, String lastName, String password, long roles_idRoles) {
        this.idClient = idClient;
        this.ID_passport = ID_passport;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.roles_idRoles = roles_idRoles;
    }

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public String getID_passport() {
        return ID_passport;
    }

    public void setID_passport(String ID_passport) {
        this.ID_passport = ID_passport;
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

    public long getRoles_idRoles() {
        return roles_idRoles;
    }

    public void setRoles_idRoles(long roles_idRoles) {
        this.roles_idRoles = roles_idRoles;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "idClient=" + idClient +
                ", ID_passport='" + ID_passport + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", roles_idRoles=" + roles_idRoles +
                '}';
    }
}


