package by.it.naumenko.project2.java.beens;

public class Profil {
    private long id_profil;
    private String name_profil;
    private String lastName_profil;
    private int dayBirth;
    private String mountBirth;
    private int yearBirth;
    private String pol;
    private String city;
    private String street;
    private int home;
    private int korpus;
    private int kvartira;
    private String tel;
    private int kol_zakaz;
    private String about;
    private long id_user;


    public void setId_profil(long id_profil) {
        this.id_profil = id_profil;
    }

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

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
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

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setKol_zakaz(int kol_zakaz) {
        this.kol_zakaz = kol_zakaz;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }


    public long getId_profil() {
        return id_profil;
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

    public int getYearBirth() {
        return yearBirth;
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

    public String getTel() {
        return tel;
    }

    public int getKol_zakaz() {
        return kol_zakaz;
    }


    @Override
    public String toString() {
        return "Profil{" +
                "id_profil=" + id_profil +
                ", name_profil='" + name_profil + '\'' +
                ", lastName_profil='" + lastName_profil + '\'' +
                ", dayBirth=" + dayBirth +
                ", mountBirth='" + mountBirth + '\'' +
                ", yearBirth=" + yearBirth +
                ", pol='" + pol + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home=" + home +
                ", korpus=" + korpus +
                ", kvartira=" + kvartira +
                ", tel='" + tel + '\'' +
                ", kol_zakaz=" + kol_zakaz +
                ", about='" + about + '\'' +
                ", id_user=" + id_user +
                '}';
    }

    public Profil(long id_profil, String name_profil,
                  String lastName_profil, int dayBirth,
                  String mountBirth, int yearBirth,
                  String pol, String city,
                  String street, int home,
                  int korpus, int kvartira,
                  String tel, int kol_zakaz,
                  String about, long id_user) {
        this.id_profil = id_profil;
        this.name_profil = name_profil;
        this.lastName_profil = lastName_profil;
        this.dayBirth = dayBirth;
        this.mountBirth = mountBirth;
        this.yearBirth = yearBirth;
        this.pol = pol;
        this.city = city;
        this.street = street;
        this.home = home;
        this.korpus = korpus;
        this.kvartira = kvartira;
        this.tel = tel;
        this.kol_zakaz = kol_zakaz;
        this.about = about;
        this.id_user = id_user;
    }

    public Profil(long id_profil, long id_user) {
        this.id_profil = id_profil;
        this.id_user = id_user;
    }

    public Profil() {
    }
}
