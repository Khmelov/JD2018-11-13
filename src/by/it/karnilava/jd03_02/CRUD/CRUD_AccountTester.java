package by.it.karnilava.jd03_02.CRUD;

import by.it.karnilava.jd03_02.beans.Account;

import java.sql.SQLException;

public class CRUD_AccountTester {
    public static void main(String[] args) throws SQLException {


    //`idAccounts`, `Number`, `Balance`, `Client_idClient`, `Type of account_idType of account`, `State options_idState options`
   AccountCRUD accountCRUD = new AccountCRUD();
   Account account = new Account();

account.setNumberOfAccount("3014123456999");
account.setBalance("9999");
account.setIdClient(1);
account.setIdType(1);
account.setIdState(1);




        if (accountCRUD.create(account)) {
        System.out.println("CREATE: " + account);

            account.setBalance("6099");
            account.setIdType(2);


    }


        if (accountCRUD.update(account)) {
        System.out.println("UPDATE: " + account);
       account = accountCRUD.read(account.getIdAccount());
        System.out.println("READ: " + account);
    }

        if (accountCRUD.delete(account))
            System.out.println("DELETE: " + account);
}
}

