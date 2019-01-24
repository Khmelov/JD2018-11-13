package by.it.markelov.jd03_02.beans;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int roles_ID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getRoles_ID() {
        return roles_ID;
    }

    public void setRoles_ID(int roles_ID) {
        this.roles_ID = roles_ID;
    }

    public User(int id, String login, String password, String email, int roles_ID) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.roles_ID = roles_ID;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                roles_ID == user.roles_ID &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, roles_ID);
    }

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
