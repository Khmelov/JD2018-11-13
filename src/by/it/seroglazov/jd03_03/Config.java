package by.it.seroglazov.jd03_03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private String dataBaseName;
    private String dataBaseURL;
    private String userName;
    private String password;

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public String getDataBaseURL() {
        return dataBaseURL;
    }

    public void setDataBaseURL(String dataBaseURL) {
        this.dataBaseURL = dataBaseURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void loadFromXml(String xmlFileName) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(new FileInputStream(xmlFileName)); //auto close stream
        dataBaseName = properties.getProperty("dataBaseName");
        dataBaseURL = properties.getProperty("dataBaseURL");
        userName = properties.getProperty("userName");
        password = properties.getProperty("password");
    }
}
