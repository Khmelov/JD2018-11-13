package by.it._examples_.jd02_09.gson;
//это POJO класс для экспериметров с JSON
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
//минимально достаточно указать только эту аннотацию
class Dev {
    private int id = 0;
    private String name;
    private List skills = new ArrayList<String>();

    public Dev() {};

    public Dev(String name, String[] arraySkills) {
        this.id = ++id;
        this.name = name;
        setSkills(arraySkills);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "DevPOJO{" +
                "\nid=" + id +
                ",\nname='" + name + '\'' +
                ",\nskills=" + skills +
                "\n}";
    }

    public void setSkills(String[] arraySkills) {
        for (String skill : arraySkills)
            this.skills.add(skill);
    }
    public void setSkills(List skills) {
        this.skills = skills;
    }
}
