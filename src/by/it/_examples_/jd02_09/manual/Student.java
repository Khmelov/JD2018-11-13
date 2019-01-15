package by.it._examples_.jd02_09.manual;

//импорты
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

//-------------------- описание отдельного класса Student -----------------------------
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)     // FIELD - все поля в XML
@XmlType(name = "Student", propOrder = {  // PROPERTY - только  с геттерами и сеттерами
        "name",                           // PUBLIC_MEMBER - только public
        "nickname",                       // NONE - ни одно
        "telephone",
        "address"
})
public class Student {
    @XmlAttribute(required = true) //опишем логин как аттрибут
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class) //тип адаптера
    @XmlID                         //и ключевой (уникальный)
    private String login;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String nickname;
    @XmlAttribute(required = false)
    private String faculty;
    @XmlElement(required = true)
    private int telephone;
    @XmlElement(required = true)
    private Address address = new Address();
    public Student() { } // необходим для маршаллизации/демаршалиизации XML

    public Student(String login, String name, String nickname, String faculty, int telephone, Address address) {
        this.login = login;
        this.name = name;
        this.nickname = nickname;
        this.faculty = faculty;
        this.telephone = telephone;
        this.address = address;
    }

    //getters
    public String getLogin() {
        return login;
    }
    public String getName() {
        return name;
    }
    public String getNickname() {
        return nickname;
    }
    public String getFaculty() {
        return faculty;
    }
    public int getTelephone() {
        return telephone;
    }
    public Address getAddress() {
        return address;
    }
    //setters
    public void setLogin(String login) {
        this.login = login;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    //как выводить в строку
    public String toString() {
        return "\nLogin: " + login + "\nName: " + name + "\nNickame: " + nickname
                + "\nTelephone: " + telephone   + "\nFaculty: " + faculty + address.toString();
    }


    //-------------------- описание вложенного класса Address -----------------------------
    @XmlRootElement
    @XmlType(name = " address ", propOrder = {
            "city",
            "country",
            "street"
    })
    public static class Address {
        private String country;
        private String city;
        private String street;
        //конструкторы
        public Address() {// необходим для маршаллизации/демаршалиизации XML
        }
        public Address(String country, String city, String street) {
            this.country = country;
            this.city = city;
            this.street = street;
        }
        //getters
        public String getCountry() {
            return country;
        }
        public String getCity() {
            return city;
        }
        public String getStreet() {
            return street;
        }
        //setters
        public void setCountry(String country) {
            this.country = country;
        }
        public void setCity(String city) {
            this.city = city;
        }
        public void setStreet(String street) {
            this.street = street;
        }
        //как выводить в строку
        public String toString() {
            return "\nAddress:" + "\n\tCountry: " + country
                    + "\n\tCity: " + city + "\n\tStreet: " + street + "\n";
        }
    }
}
