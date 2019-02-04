package by.it.denisova.project.java.beans;

public class User {

    private long id;
    private String login;
    private String password;
    private String email;
    private long id_role;
    private long aa_Role;
    public User() {

    }


    public long getId_role() {
        return id_role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }

    public User(long id, String login, String password, String email, long id_role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.id_role = id_role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

