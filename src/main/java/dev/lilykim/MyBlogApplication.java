package dev.lilykim;

import dev.lilykim.dao.DAO;
import dev.lilykim.domain.Feed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MyBlogApplication {

    private static DAO<Feed> dao;

    public MyBlogApplication(DAO<Feed> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(MyBlogApplication.class, args);

        /*System.out.println("\n Create Feed ---------------------- \n");
        Feed feed = new Feed();
        dao.create(feed);

        System.out.println("\n One Feed ---------------------- \n");
        Optional<Feed> firstOne = dao.get(1);
        System.out.println(firstOne.get());

        System.out.println("\n All Feeds ---------------------- \n");
        List<Feed> feeds = dao.list();
        feeds.forEach(System.out::println);*/
    }

}
