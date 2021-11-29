package test10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

// Mongo JPA
@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        repository.deleteAll();

//        repository.save(new User("Alice", "Smith"));
//        repository.save(new User("Bob", "Smith1"));
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println("--------------------------------------------");
        System.out.println("User found with findByPassword(Smith):");
        List<User> users = repository.findByPassword("Smith");
        if (users.isEmpty()) System.out.println("Can not find user");
        for (User user : users) {
            System.out.println(user);
            System.out.println("---------------------------------------------");
            System.out.println("Delete User : " + user);
            repository.delete(user);
        }

    }
}
