package by.it.kruglenja.jd03_02.beans;

public class Role {
    public Role() {
    }

    public Role(long id, String role) {
        this.id = id;
        this.role = role;
    }

    private long id;
    private String role;

    public long getId() { return id; }

    public String getRole() { return role; }

    public void setId(long id) { this.id = id; }

    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}

