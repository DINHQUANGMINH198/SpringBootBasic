package test4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

//Example @Component, @Service, @Repository.
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        // Lấy ra bean PersonService
        PersonService personService = context.getBean(PersonService.class);
        // Lấu ra random một người từ tầng service
        Person p = personService.getRandomPerson();
        System.out.println(p);
    }

}
