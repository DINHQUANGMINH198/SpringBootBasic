package test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//Example @Autowired - @Primary - @Qualifier
@SpringBootApplication
public class Test2App {
    public static void main(String[] args) {
        // ApplicationContext chính là container, chứa toàn bộ các Bean

        ApplicationContext context = SpringApplication.run(Test2App.class, args);

        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        Person person = context.getBean(Person.class);

        System.out.println("Person Instance: " + person);

        System.out.println("Person Outfit: " + person.outfit);

        person.outfit.wear();
    }

}
