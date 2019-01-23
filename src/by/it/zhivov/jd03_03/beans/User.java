package by.it.zhivov.jd03_03.beans;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private long id;
    private String name;
    private String login;
    private String password;
    private String dateOfBirth;
    private String email;
    private String tel;
    private long roles_Id;

    public User() {
    }

    public User(long id, String name, String login, String password, String dateOfBirth, String email, String tel, long roles_Id) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.tel = tel;
        this.roles_Id = roles_Id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String  getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getRoles_Id() {
        return roles_Id;
    }

    public void setRoles_Id(long roles_Id) {
        this.roles_Id = roles_Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", roles_Id=" + roles_Id +
                '}';
    }
}
