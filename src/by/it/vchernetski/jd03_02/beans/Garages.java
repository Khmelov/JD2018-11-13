package by.it.vchernetski.jd03_02.beans;

public class Garages {
    private long id;
    private String adress;
    private int carplaces;
    private long users_id;

    public Garages() {
    }

    public Garages(long id, String adress, int carplaces, long users_id) {
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
        return "Garages{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", carplaces=" + carplaces +
                ", users_id=" + users_id +
                '}';
    }
}
