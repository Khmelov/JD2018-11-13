package by.it.skarpovich.jd03_02;//package by.it.skarpovich.jd03_01;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//
//class Connect implements CONFIG {
//
//    static Statement createConnection() {
//
//        Statement statement=null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            System.out.println("Error loading driver: " + e);
//        }
//        try {
//            Connection connection = DriverManager.getConnection(CONFIG.URL_DB, CONFIG.USER_DB, CONFIG.PASSWORD_DB);
//            statement = connection.createStatement();
//            if (!connection.isClosed())
//                System.out.println("Connection initiated");
//            connection.close();
//            if (connection.isClosed())
//                System.out.println("Connection interrupted");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //return connection; <--ASK. + ask resources(close). + ask transfer statement or connection
//     return statement;
//    }
//}
//
//
