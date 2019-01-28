package by.it.nickgrudnitsky.jd03_03.beans;

public class Viewer {
    private long id;
    private String email;
    private String password;
    private String nickname;
    private long roles_id;

    public Viewer() {
    }

    public Viewer(String email, String password, String nickname, long roles_id) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.roles_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "viewer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
