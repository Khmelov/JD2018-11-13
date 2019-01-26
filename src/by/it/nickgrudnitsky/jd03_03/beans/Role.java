package by.it.nickgrudnitsky.jd03_03.beans;

public class Role {
    private long id;
    private String role;

    public Role(String role) {
        this.role = role;
    }

    public Role() {

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

    @Override
    public String toString() {
        return "role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
