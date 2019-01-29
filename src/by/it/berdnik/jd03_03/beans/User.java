package by.it.berdnik.jd03_03.beans;

public class User {

    private long id;
    private String nickname;
    private String password;
    private String email;
    private long roles_Id;

    public User() {
    }

    public User(long id, String nickname, String password, String email, long roles_Id) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.roles_Id = roles_Id;
    }

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
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles_Id=" + roles_Id +
                '}';
    }
}
