package by.it.lobkova.project.java.beans;

public class Task {

    private long id;
    private String name_task;
    private String description_task;
    private long date;
    private long goals_ID;

    public Task() {

    }

    public Task(long id, String name_task, String description_task, long date, long goals_ID) {
        this.id = id;
        this.name_task = name_task;
        this.description_task = description_task;
        this.date = date;
        this.goals_ID = goals_ID;
    }

    public long getGoals_ID() {
        return goals_ID;
    }

    public void setGoals_ID(long goals_ID) {
        this.goals_ID = goals_ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName_task() {
        return name_task;
    }

    public void setName_task(String name_task) {
        this.name_task = name_task;
    }

    public String getDescription_task() {
        return description_task;
    }

    public void setDescription_task(String description_task) {
        this.description_task = description_task;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name_task='" + name_task + '\'' +
                ", description_task='" + description_task + '\'' +
                ", date=" + date +
                ", goals_ID=" + goals_ID +
                '}';
    }
}
