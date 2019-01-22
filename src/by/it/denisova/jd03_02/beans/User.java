package by.it.denisova.jd03_02.beans;

public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    private long id_role;

    public User() {

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

    public long getIdRole() {
        return id_role;
    }

    public void setIdRole(long idRole) {
        this.id_role = idRole;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id_role=" + id_role +
                '}';
    }
}

