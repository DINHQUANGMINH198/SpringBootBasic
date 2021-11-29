package test9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

//MySQL JPA
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        // Lấy ra toàn bộ user trong db
        userRepository.findAll().forEach(System.out::println);

        // Lưu user xuống database
        User user = userRepository.save(new User("aa", "minhdq"));
        // Khi lưu xong, nó trả về User đã lưu kèm theo Id.
        System.out.println("User vừa lưu có ID: " + user.getId());
        Integer userId = user.getId();
        // Update user
        // Lưu ý, lúc này đối tượng user đã có Id.
        // Nên nó sẽ update vào đối tượng có Id này
        // chứ không insert một bản ghi mới
        userRepository.save(user);

        // Query lấy ra user vừa xong để kiểm tra xem.
        Optional<User> user2 = userRepository.findById(userId);
        if (user2.isPresent()) {
            User u3 = user2.get();
        }

        System.out.println("User: " + user);
        System.out.println("User2: " + user2);

        // Xóa User khỏi DB
//        userRepository.delete(user);
//
//
        List<User> user3 = userRepository.findAllByUsername("aa");
        System.out.println("User3: " + user3);

    }
}
