package test6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        SimpleBean simpleBean = context.getBean(SimpleBean.class);

        System.out.println("Simple Bean Example: "+simpleBean);

        DatabaseConnector mysql = (DatabaseConnector) context.getBean("mysqlConnector");
        mysql.connect();

        DatabaseConnector mongodb = (DatabaseConnector) context.getBean("mongodbConnector");
        mongodb.connect();
    }
}
