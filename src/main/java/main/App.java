package main;

import config.AppContextConfig;
import files.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppContextConfig.class);
        BookDAO bookDAO = context.getBean(BookDAO.class);
        Authenticator authenticator = context.getBean(Authenticator.class);
        Book book = new Book("testTitle", "testAuthor");
        try {
            bookDAO.add(book);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        System.out.println(bookDAO.getAll());
        ((ConfigurableApplicationContext) context).close();


    }
//        User user = new User("james", "james1");
//
//        BookDAO bookDAO = new BookDAO();
////        bookDAO.getAll();
//        Book book = new Book("test", "test");
//
//
//        try {
//            bookDAO.delete(book);
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(bookDAO.getAll());
//    }
}
