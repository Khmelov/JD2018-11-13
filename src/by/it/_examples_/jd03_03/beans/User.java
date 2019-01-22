package by.it._examples_.jd03_03.beans;


public class User {

    private int id = 0;
    private String login;
    private String password;
    private String email;
    private Integer fk_Roles = 0;

    public User() {
    }

    public User(int id, String login, String password, String email, Integer fk_Roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_Roles = fk_Roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getFk_Roles() {
        return fk_Roles;
    }

    public void setFk_Roles(Integer fk_Roles) {
        this.fk_Roles = fk_Roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", Role=" + fk_Roles +
                '}';
    }
}
