package by.it.naumenko.project.java.beens;

public class Profil {
    private long id_profil;
    private String name_profil;
    private String lastName_profil;
    private int dayBirth;
    private String mountBirth;
    private int yearDirth;
    private String pol;
    private String city;
    private String street;
    private int home;
    private int korpus;
    private int kvartira;
    private String about;
    private long id_user;


    public void setName_profil(String name_profil) {
        this.name_profil = name_profil;
    }

    public void setLastName_profil(String lastName_profil) {
        this.lastName_profil = lastName_profil;
    }

    public void setDayBirth(int dayBirth) {
        this.dayBirth = dayBirth;
    }

    public void setMountBirth(String mountBirth) {
        this.mountBirth = mountBirth;
    }

    public void setYearDirth(int yearDirth) {
        this.yearDirth = yearDirth;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setKorpus(int korpus) {
        this.korpus = korpus;
    }

    public void setKvartira(int kvartira) {
        this.kvartira = kvartira;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }


    public String getName_profil() {
        return name_profil;
    }

    public String getLastName_profil() {
        return lastName_profil;
    }

    public int getDayBirth() {
        return dayBirth;
    }

    public String getMountBirth() {
        return mountBirth;
    }

    public int getYearDirth() {
        return yearDirth;
    }

    public String getPol() {
        return pol;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getKorpus() {
        return korpus;
    }

    public int getKvartira() {
        return kvartira;
    }

    public String getAbout() {
        return about;
    }

    public long getId_user() {
        return id_user;
    }

    @Override
    public String toString() {
        return "profil{" +
                "id_profil=" + id_profil +
                ", name_profil='" + name_profil + '\'' +
                ", lastName_profil='" + lastName_profil + '\'' +
                ", dayBirth=" + dayBirth +
                ", mountBirth='" + mountBirth + '\'' +
                ", yearDirth=" + yearDirth +
                ", pol='" + pol + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home=" + home +
                ", korpus=" + korpus +
                ", kvartira=" + kvartira +
                ", about='" + about + '\'' +
                ", id_user=" + id_user +
                '}';
    }

    public Profil(long id_profil, String name_profil,
                  String lastName_profil, int dayBirth,
                  String mountBirth, int yearDirth,
                  String pol, String city,
                  String street, int home,
                  int korpus, int kvartira,
                  String about, long id_user) {
        this.id_profil = id_profil;
        this.name_profil = name_profil;
        this.lastName_profil = lastName_profil;
        this.dayBirth = dayBirth;
        this.mountBirth = mountBirth;
        this.yearDirth = yearDirth;
        this.pol = pol;
        this.city = city;
        this.street = street;
        this.home = home;
        this.korpus = korpus;
        this.kvartira = kvartira;
        this.about = about;
        this.id_user = id_user;
    }

    public Profil() {
    }
}
