package by.it.karnilava.jd03_02.CRUD;

import by.it.karnilava.jd03_02.beans.Role;
import by.it.karnilava.jd03_02.beans.StateOfAccount;

import java.sql.SQLException;

public class CRUD_StateTester {

    public static void main(String[] args) throws SQLException {


        StateCRUD stateCRUD = new StateCRUD();
        StateOfAccount stateOfAccount = new StateOfAccount();


        stateOfAccount.setState("Under restrictions");


        if (stateCRUD.create(stateOfAccount)) {
            System.out.println("CREATE: " + stateOfAccount);
            stateOfAccount.setState("Limited");

        }


        if (stateCRUD.update(stateOfAccount)) {
            System.out.println("UPDATE: " + stateOfAccount);
            stateOfAccount = stateCRUD.read(stateOfAccount.getIdState());
            System.out.println("READ: " + stateOfAccount);
        }

//        if (stateCRUD.delete(stateOfAccount))
//            System.out.println("DELETE: " + stateOfAccount);
    }
}
