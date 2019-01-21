package by.it.zhivov.jd03_02.beans;

public class Roles {
    private long id;
    private String role;

    public Roles() {
    }

    public Roles(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
