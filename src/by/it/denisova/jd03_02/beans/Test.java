package by.it.denisova.jd03_02.beans;

public class Test {
    private long id;
    private String test_name;

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
                '}';
    }
}
