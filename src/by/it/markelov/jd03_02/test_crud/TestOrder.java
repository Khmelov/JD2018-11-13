package by.it.markelov.jd03_02.test_crud;

import by.it.markelov.jd03_02.beans.Order;
import by.it.markelov.jd03_02.crud.OrderCRUD;

import java.sql.SQLException;

public class TestOrder {
    public static void main(String[] args) {
        OrderCRUD orderCRUD = new OrderCRUD();
        Order order = new Order(0, "NTest", 555, "CTest", 25.2, 2);
        try {
//==================CREATE=========================
            orderCRUD.create(order);

//==================READ===========================
            //System.out.println(orderCRUD.read(10));

//===================UPDATE========================
            //order = new Order(11, "NTest+++", 42,"PTest+++", 555, 2);
            //orderCRUD.update(order);

//===================DELETE========================
            //orderCRUD.delete(order);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
