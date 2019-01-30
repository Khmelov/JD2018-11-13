package by.it.denisova.project.java.beans;

public class Question {
    private long id;
    private String question;
    private long id_test;

    public Question() {
    }

    public Question(long id, String question, long id_test) {
        this.id = id;
        this.question = question;
        this.id_test = id_test;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getId_test() {
        return id_test;
    }

    public void setId_test(long id_test) {
        this.id_test = id_test;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", id_test=" + id_test +
                '}';
    }
}
