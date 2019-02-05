package by.it.kruglenja.Project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Reset {
    public static void main(String[] args) {
    Connect.deleteDb();
    Connect.createDb();
    }
}