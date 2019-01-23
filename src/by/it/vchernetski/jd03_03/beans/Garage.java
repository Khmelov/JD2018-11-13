package by.it.vchernetski.jd03_03.beans;

public class Garage {
    private long id;
    private String adress;
    private int carplaces;
    private long users_id;

    public Garage() {
    }

    public Garage(long id, String adress, int carplaces, long users_id) {
        this.id = id;
        this.adress = adress;
        this.carplaces = carplaces;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getCarplaces() {
        return carplaces;
    }

    public void setCarplaces(int carplaces) {
        this.carplaces = carplaces;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", carplaces=" + carplaces +
                ", users_id=" + users_id +
                '}';
    }
}
