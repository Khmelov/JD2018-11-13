package by.it.denisova.project.java.dao;

import by.it.denisova.project.java.beans.*;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao =  Dao.getDao();

        System.out.println("-------------------USER----------------------");

        User user = new User();
        user.setLogin("katiaDEn23.01");
        user.setPassword("qwerty23");
        user.setEmail("katua@mail.ru");
        user.setId_role(1);
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

//        if(dao.test.delete(test)) {
//            System.out.println("test deleted" + test);
//        }

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
//        if(dao.question.delete(question)) {
//            System.out.println("Deleted " + question);
//        }

        System.out.println("-------------------Answer----------------------");
        Answer answer = new Answer();
        answer.setAnswer("some question");
        answer.setId_question(1);
        answer.setStatus("right");
        if(dao.answer.create(answer)) {
            System.out.println("Created " + answer);
        }
        System.out.println(answer.getId());

        answer.setAnswer("1926");
        if(dao.answer.update(answer)) {
            System.out.println("UPDATED " + answer);
        }
        answer = dao.answer.read(answer.getId());
        System.out.println( answer);

        if(dao.answer.delete(answer)) {
            System.out.println("DELETED " +answer);
        }

        System.out.println("-------------------LESSON----------------------");
        Lesson lesson = new Lesson();
        lesson.setId_test(1);
        lesson.setId_theme(1);
        lesson.setId_type(1);
        lesson.setTheory("some theory 1717");

        if(dao.lesson.create(lesson)) {
            System.out.println("CREATED " + lesson);
        }

       lesson = dao.lesson.read(lesson.getId());
       System.out.println("READE " + lesson); //не работает Read кидается NullPointerException

        lesson.setTheory("wrong");
        if(dao.lesson.update( lesson)) {
            System.out.println("Updated " +  lesson);
        }


        if(dao.lesson.delete(lesson)) {
            System.out.println("Deleted " +  lesson);
        }

        System.out.println("-------------------TYPE----------------------");

        TypeLesson typeLesson = new TypeLesson();
        typeLesson.setType("some Type23:45");
        if(dao.type.create(typeLesson)) {
            System.out.println("Created " + typeLesson);
        }

        typeLesson.setType("new type 23:48");
        if (dao.type.update(typeLesson)) {
            System.out.println("Updated " + typeLesson);
        }

        typeLesson = dao.type.read(typeLesson.getId());
        System.out.println(typeLesson);

        if (dao.type.delete(typeLesson)) {
            System.out.println("Deleted " + typeLesson);
        }

        List<Test> tests = dao.test.getAll();
        for (Test test1 :tests) {
            System.out.println(test1);
        }
  }
}
