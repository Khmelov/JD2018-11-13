package by.it.naumenko.jd03_02.beens;

public class Roles {
    private long id_role;
    private String role;

    public Roles() {
    }

    public long getId_role() {
        return id_role;
    }

    public String getRole() {
        return role;
    }

    public void setId_role(long id_role) {
        this.id_role = id_role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id_role=" + id_role +
                ", role='" + role + '\'' +
                '}';
    }

    public Roles(long id_role, String role) {
        this.id_role = id_role;
        this.role = role;
    }
}
