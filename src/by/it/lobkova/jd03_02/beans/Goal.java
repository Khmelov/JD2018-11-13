package by.it.lobkova.jd03_02.beans;

public class Goal {

    private long id;
    private String name_goal;
    private String description_goal;
    private long beginDate;
    private long endDate;
    private long user_id;

    public Goal() {

    }

    public Goal(long id, String name_goal, String description_goal, long beginDate, long endDate, long user_id) {
        this.id = id;
        this.name_goal = name_goal;
        this.description_goal = description_goal;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName_goal() {
        return name_goal;
    }

    public void setName_goal(String name_goal) {
        this.name_goal = name_goal;
    }

    public String getDescription_goal() {
        return description_goal;
    }

    public void setDescription_goal(String description_goal) {
        this.description_goal = description_goal;
    }

    public long getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(long beginDate) {
        this.beginDate = beginDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", name_goal='" + name_goal + '\'' +
                ", description_goal='" + description_goal + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", user_id=" + user_id +
                '}';
    }
}
