package test1;

//import minhdq.demo.springboot.DemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;



// Example @Component và @Autowired
@SpringBootApplication
public class Test1App {
    Logger logger = LoggerFactory.getLogger(Test1App.class);
    public static void main(String[] args) {
        // ApplicationContext chính là container, chứa toàn bộ các Bean
        ApplicationContext context= SpringApplication.run(Test1App.class, args);
        // Khi chạy xong, lúc này context sẽ chứa các Bean có đánh
        // dấu @Component.

        // Lấy Bean ra bằng cách
        Outfit outfit = context.getBean(Outfit.class);

        System.out.println("Output Instance: " + outfit);
        outfit.wear();

        Person person = context.getBean(Person.class);

        System.out.println("Person Instance: " + person);

        System.out.println("Person Outfit: " + person.outfit);

        person.outfit.wear();

        // Kiểm tra 2 đối tượng
        System.out.println((person.outfit == outfit));
    }

}
