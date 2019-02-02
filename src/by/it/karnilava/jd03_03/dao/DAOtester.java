package by.it.karnilava.jd03_03.dao;

import by.it.karnilava.jd03_03.beans.*;

import java.sql.SQLException;

public class DAOtester {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getDao();


        Client client = new Client();
       client.setPassport("3014123456999");
       client.setFirstName("Michael");
       client.setLastName("Volkov");
       client.setPassword("mishaMisha");
       client.setIdRoles(2);


        if (dao.client.create(client)) {
            System.out.println("CREATE: " + client);
            client.setFirstName("Mikhail");
            client.setIdRoles(1);
        }
        if (dao.client.update(client))
            System.out.println("UPDATE: " + client);
        client = dao.client.read(client.getId());
        System.out.println("READ: " + client);
//        if (dao.client.delete(client))
//            System.out.println("DELETE: " + client);

        //CHECKING ACCOUNT

        Account account = new Account();
        account.setNumber("3014321654987");
        account.setBalance("45000");
        account.setIdClient(client.getId());
        account.setIdType(2);
        account.setIdState(1);

        if (dao.account.create(account)){
            System.out.println("CREATE: "+account);
            account.setBalance("35000");
        }
        if (dao.account.update(account))
            System.out.println("UPDATE: " + account);
        account = dao.account.read(account.getId());
        System.out.println("READ " + account);
//        if (dao.account.delete(account));
//        System.out.println("DELETE "+ account);

        //CHECKING ROLE

        Role role = new Role();
        role.setRole("guest");

        if (dao.role.create(role)){
            System.out.println("CREATE: " + role);
        role.setRole("Guest");}
       if (dao.role.update(role))
        System.out.println("UPDATE: " + role);
        role = dao.role.read(role.getId());
        System.out.println("READ " + role);
//        if(dao.role.delete(role));
//        System.out.println("DELETE"+role);


//        CHECKING STATE

        State state = new State();
        state.setState("limited");

        if (dao.state.create(state)){
            System.out.println("CREATE: " + state);
            state.setState("Under restrictions");}
        if (dao.state.update(state))
            System.out.println("UPDATE: " + state);
        state = dao.state.read(state.getId());
        System.out.println("READ " + state);
//        if(dao.state.delete(state));
//        System.out.println("DELETE"+state);


        //CHECKING TYPE

        Type type = new Type();
        type.setType("guatantee");

        if (dao.type.create(type)){
            System.out.println("CREATE: " + type);
            type.setType("Letter of credit");}
        if (dao.type.update(type))
            System.out.println("UPDATE: " + type);
        type = dao.type.read(type.getId());
        System.out.println("READ " + type);
//        if(dao.type.delete(type));
//        System.out.println("DELETE"+type);


    }
}
