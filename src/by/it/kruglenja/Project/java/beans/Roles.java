package by.it.kruglenja.Project.java.beans;

public class Roles {
    public Roles() {
    }

    public Roles(long id, String role) {
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

