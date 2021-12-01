package test5;

import hello.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import test5.others.OtherGirl;

//@ComponentScan("test5.others") //cách 1
@SpringBootApplication(scanBasePackages = "test5.others")//cách 2
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        HelloService a = context.getBean(HelloService.class); // call cusstom stater
        a.sayHello();
        try {
            Girl girl = context.getBean(Girl.class);
            System.out.println("Bean: " + girl.toString());
        } catch (Exception e) {
            System.out.println("Bean Girl không tồn tại");
        }

        try {
            OtherGirl otherGirl = context.getBean(OtherGirl.class);
            System.out.println("Bean: " + otherGirl.toString());
        } catch (Exception e) {
            System.out.println("Bean Girl không tồn tại");
        }
    }
}
