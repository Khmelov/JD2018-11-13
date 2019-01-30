package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao =  Dao.getDao();

        System.out.println("-------------------USER----------------------");

        User user = new User();
        user.setLogin("katiaDEn23.01");
        user.setPassword("qwerty23");
        user.setEmail("katua@mail.ru");
        user.setIdRole(1);
        if(dao.user.create(user)) {
            System.out.println("Created " + user);
        }
        user.setLogin("belebirda");
        if (dao.user.update(user)) {
            System.out.println("Updated " + user);
        }
        user = dao.user.read(user.getId());
        System.out.println("read" +user);

        if(dao.user.delete(user)){
            System.out.println("user deleted " + user);
        }

        System.out.println("-------------------ROLE----------------------");
        Role role = new Role();
        role.setRole("Admin");
        if(dao.role.create(role)) {
            System.out.println("created " + role);
        }
        role.setRole("user");
        if(dao.role.update(role)){
            System.out.println("Updated " + role);
        }
        role = dao.role.read((role.getId()));
        System.out.println("read " + role);

        System.out.println("-------------------TEST----------------------");
        Test test = new Test();
        test.setTest_name("work");
        if(dao.test.create(test)) {
            System.out.println("Created " + test);
        }

        test.setTest_name("parent");
        if(dao.test.update(test)){
            System.out.println("Updated " + test);
        }

        test = dao.test.read(test.getId());
        System.out.println("read" + test);

        if(dao.test.delete(test)) {
            System.out.println("test deleted" + test);
        }

        System.out.println("-------------------QUESTION----------------------");
        Question question = new Question();
        question.setQuestion("some question");
        question.setId_test(1);
        if(dao.question.create(question)) {
            System.out.println("Created " + question);
        }
        question.setQuestion("some question 22");

        if(dao.question.update(question)) {
            System.out.println("Updated " + question);
        }

        question = dao.question.read(question.getId());
        System.out.println("read!!!" + question);
        if(dao.question.delete(question)) {
            System.out.println("Deleted " + question);
        }

        System.out.println("-------------------Answer----------------------");
        Answer answer = new Answer();
        answer.setAnswer("some question");
        answer.setId_question(1);
        answer.setStatus("right");
        if(dao.answer.create(answer)) {
            System.out.println("Created " + answer);
        }
        System.out.println(answer.getId());

        answer = dao.answer.read( answer.getId());
        System.out.println( answer);

        System.out.println("-------------------LESSON----------------------");
        Lesson lesson = new Lesson();
        lesson.setId_test(1);
        lesson.setId_theme(1);
        lesson.setId_type(1);
        lesson.setTheory("some theory 1717");

        if(dao.lesson.create(lesson)) {
            System.out.println("CREATED " + lesson);
        }

//        lesson = dao.lesson.read(answer.getId());
//        System.out.println("READE " + lesson); не работает Read кидается NullPointerException

//        answer.setAnswer("wrong");
//        if(dao.answer.update( answer)) {
//            System.out.println("Updated " +  answer);
//        }


//        if(dao.answer.delete( answer)) {
//            System.out.println("Deleted " +  answer);
//        }
  }
}
