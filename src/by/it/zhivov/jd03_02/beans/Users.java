package by.it.zhivov.jd03_02.beans;

public class Users {
    private long id;
    private String name;
    private String login;
    private String password;
    private long roles_Id;

    public Users() {
    }

    public Users(long id, String name, String login, String password, long roles_Id) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
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

    public long getRoles_Id() {
        return roles_Id;
    }

    public void setRoles_Id(long roles_Id) {
        this.roles_Id = roles_Id;
    }
}
