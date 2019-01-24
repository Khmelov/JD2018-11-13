package by.it.nickgrudnitsky.jd03_02.beans;

public class Streamer {
    private long id;
    private String email;
    private String password;
    private String channelname;
    private long roles_id;

    public Streamer() {
    }

    public Streamer(String email, String password, String channelname, long roles_id) {
        this.email = email;
        this.password = password;
        this.channelname = channelname;
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

    public String getChannelname() {
        return channelname;
    }

    public void setChannelname(String channelname) {
        this.channelname = channelname;
    }

    public long getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long roles_id) {
        this.roles_id = roles_id;
    }

    @Override
    public String toString() {
        return "streamer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", channelname='" + channelname + '\'' +
                ", roles_id=" + roles_id +
                '}';
    }
}
