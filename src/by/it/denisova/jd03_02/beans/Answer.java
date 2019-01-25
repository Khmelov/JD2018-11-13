package by.it.denisova.jd03_02.beans;

public class Answer {
    private long id;
    private long id_question;
    private String answer;
    private String status;

    public Answer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_question() {
        return id_question;
    }

    public void setId_question(long id_question) {
        this.id_question = id_question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", id_question=" + id_question +
                ", answer='" + answer + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
