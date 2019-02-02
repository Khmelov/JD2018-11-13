package by.it.karnilava.jd03_02.CRUD;

import by.it.karnilava.jd03_02.beans.TypeOfAccount;

import java.sql.SQLException;

public class CRUD_TypeTester {

    public static void main(String[] args) throws SQLException {
        TypeCRUD typeCRUD = new TypeCRUD();

        TypeOfAccount typeOfAccount = new TypeOfAccount();

        typeOfAccount.setType("guarantee");


        if (typeCRUD.create(typeOfAccount)) {
            System.out.println("CREATE: " + typeOfAccount);
            typeOfAccount.setType("letter of credit");

        }


        if (typeCRUD.update(typeOfAccount)) {
            System.out.println("UPDATE: " + typeOfAccount);
            typeOfAccount = typeCRUD.read(typeOfAccount.getIdType_of_account());
            System.out.println("READ: " + typeOfAccount);
        }

        if (typeCRUD.delete(typeOfAccount))
            System.out.println("DELETE: " + typeOfAccount);
    }
}
