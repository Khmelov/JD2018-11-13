package by.it.seroglazov.jd03_02.beans;

public class User {
    private long id;
    private String nickname;
    private String password;
    private String email;
    private long roles_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    public User() {
    }

    public User(long id, String nickname, String password, String email, long roles_id) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.roles_id = roles_id;
    }
}
