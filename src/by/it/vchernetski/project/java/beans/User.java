package by.it.vchernetski.project.java.beans;

public class User {
    private long id;
    private String fio;
    private String nickname;
    private String email;
    private String password;
    private int numbergarages;
    private long roles_id;

    public User() {
    }

    public User(long id, String fio, String nickname, String email, String password, int numbergarages, long roles_id) {
        this.id = id;
        this.fio = fio;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.numbergarages = numbergarages;
        this.roles_id = roles_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getNumbergarages() {
        return numbergarages;
    }

    public void setNumbergarages(int numbergarages) {
        this.numbergarages = numbergarages;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", numbergarages=" + numbergarages +
                ", roles_id=" + roles_id +
                '}';
    }
}
