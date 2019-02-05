package by.it.denisova.project.java.beans;

import java.util.List;

public class Test {
    private long id;
    private String test_name;
    private List<Question> questionList;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Test() {
    }

    public Test(long id, String test_name) {
        this.id = id;
        this.test_name = test_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }


    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", test_name='" + test_name + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}
