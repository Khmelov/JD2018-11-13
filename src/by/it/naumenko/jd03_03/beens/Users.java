package by.it.naumenko.jd03_03.beens;

public class Users {
    private long id_user;
    private String login;
    private String password;
    private String email;
    private long id_role;

    public Users(long id_user,
                 String login,
                 String password,
                 String email,
                 long id_roles) {
        this.id_user = id_user;
        this.login = login;
        this.password = password;
        this.email = email;
        this.id_role = id_roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_user=" + id_user +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id_roles=" + id_role +
                '}';
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId_roles(long id_roles) {
        this.id_role = id_roles;
    }

    public long getId_user() {
        return id_user;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getId_roles() {
        return id_role;
    }

    public Users() {
    }
}
