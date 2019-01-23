package by.it._examples_.jd03_03.badpath;

import java.io.Serializable;

public class User implements Serializable{

    public User(int id, String login, String email, String password, int fk_roles) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.fk_roles = fk_roles;
    }

    public User() {
    }

    private int id;
    private String login;
    private String email;
    private String password;
    private int fk_roles;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFk_roles() {
        return fk_roles;
    }

    public void setFk_roles(int fk_roles) {
        this.fk_roles = fk_roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fk_roles=" + fk_roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (fk_roles != user.fk_roles) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + fk_roles;
        return result;
    }
}
