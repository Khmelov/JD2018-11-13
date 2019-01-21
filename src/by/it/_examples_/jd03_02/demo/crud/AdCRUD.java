package by.it._examples_.jd03_02.demo.crud;


import by.it._examples_.jd03_02.demo.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class AdCRUD {
/*
    private int id;
    private String description;
    private String address;
    private int floor;
    private int floors;
    private String area;
    private double price;
    private int roomCount;
    private int fkUsers;

 */
    public Ad create(Ad ad) throws SQLException {
        ad.setId(0);
        //формирование строки createAdSQL по данным bean ad
        String createAdSQL = String.format(Locale.ENGLISH,
                "insert into ads(" +
                        "Description," +
                        "Address," +
                        "Floor," +
                        "Floors," +
                        "Area," +
                        "Price," +
                        "RoomCount," +
                        "FK_Users" +
                        ") values('%s','%s',%d,%d,%f,%f,%d,%d);",
                ad.getDescription(),
                ad.getAddress(),
                ad.getFloor(),
                ad.getFloors(),
                ad.getArea(),
                ad.getPrice(),
                ad.getRoomCount(),
                ad.getFkUsers()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement() //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            System.out.println(createAdSQL);

            if (1 == statement.executeUpdate(createAdSQL, RETURN_GENERATED_KEYS)) {
                //если все добавлено то узнаем последний ID
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    //извлекаем из keys последний ID
                    int id = keys.getInt(1);
                    ad.setId(id);
                }
            }
        }
        return ad;
    }

    public Ad read(int id) throws SQLException {
        Ad adResult = null;
        String readAdSQL = "SELECT * FROM ads where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            final ResultSet resultSet = statement.executeQuery(readAdSQL);
            if (resultSet.next()) {
                adResult = new Ad(
                        resultSet.getInt("ID"),
                        resultSet.getString("Description"),
                        resultSet.getString("Address"),
                        resultSet.getInt("Floor"),
                        resultSet.getInt("Floors"),
                        resultSet.getFloat("Area"),
                        resultSet.getFloat("Price"),
                        resultSet.getInt("RoomCount"),
                        resultSet.getInt("FK_Users")
                );
            }
        }
        return adResult;
    }

    public Ad update(Ad ad) throws SQLException {
        Ad adResult = null;
        String updateAdSQL = String.format(Locale.ENGLISH,
                "UPDATE ads " +
                        "SET Description = '%s'," +
                        " Address = '%s'," +
                        " Floor = %d," +
                        " Floors = %d," +
                        " Area = %f," +
                        " Price = %f," +
                        " RoomCount = %d," +
                        " FK_Users = %d" +
                " WHERE ads.ID = %d",
                ad.getDescription(),
                ad.getAddress(),
                ad.getFloor(),
                ad.getFloors(),
                ad.getArea(),
                ad.getPrice(),
                ad.getRoomCount(),
                ad.getFkUsers(),
                ad.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            System.out.println(updateAdSQL);
            if (statement.executeUpdate(updateAdSQL) == 1)
                adResult = ad;
        }
        return adResult;
    }

    public boolean delete(Ad ad) throws SQLException {
        String deleteAdSQL = String.format("DELETE FROM ads WHERE ads.ID = %d", ad.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteAdSQL) == 1);
        }
    }


}
