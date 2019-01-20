package by.it._examples_.jd03_02;

import java.sql.Connection;
import java.sql.Statement;

public class Ex_02_Insert_Rus_AD {


    public static void main(String[ ] args) {
        try (Connection connection= ConnectionCreator.getConnection();
             Statement statement=connection.createStatement()) {

            //вставляем объявления
            statement.executeUpdate(
                    "INSERT INTO ads (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                            "VALUES (2, 65000, '42', 3, 5, 'Кнорина 18', 2, 'Хорошая квартира');"
            );
            statement.executeUpdate(
                    "INSERT INTO ads (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                    "VALUES (2, 85000, '42', 3, 5, 'Независимости 35', 2, 'Элитное жилье');"            );
            statement.executeUpdate(
                    "INSERT INTO ads (RoomCount, Price, Area, Floor, Floors, Address, FK_Users, Description) "+
                    "VALUES (2, 45000, '42', 1, 1, 'Мурова 5', 2, 'Доступное жилье на окраине Минска.');"            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
