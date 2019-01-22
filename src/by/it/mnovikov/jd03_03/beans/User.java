package by.it.mnovikov.jd03_03.beans;

/**
 * Created by user on 19.01.2019.
 */
public class User {
    private long id;
    private String login;
    private String password;
    private String email;

    public User() {
    }

    public User(long id, String login, String password, String email, long roles_ID) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_ID = roles_ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getRoles_ID() {
        return roles_ID;
    }

    public void setRoles_ID(long roles_ID) {
        this.roles_ID = roles_ID;
    }

    private long roles_ID;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_ID=" + roles_ID +
                '}';
    }
}
