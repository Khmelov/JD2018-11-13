package by.it.denisova.jd03_01;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private String nameDatabase;
    private String databaseURL;
    private String userName;
    private String password;

    public String getNameDatabase() {
        return nameDatabase;
    }

    public void setNameDatabase(String nameDatabase) {
        this.nameDatabase = nameDatabase;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean load(String fileXMLName) {
        Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream(fileXMLName));
            nameDatabase = properties.getProperty("dataBaseName");
            databaseURL = properties.getProperty("dataBaseURL");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
