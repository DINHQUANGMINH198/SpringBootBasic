package test2;


import org.springframework.stereotype.Component;

/*
 Đánh dấu class bằng @Component
 Class này sẽ được Spring Boot hiểu là một Bean (hoặc dependency)
 Và sẽ được Spring Boot quản lý
 */
@Component("clothes")
public class Clothes implements Outfit {
    @Override
    public void wear() {
        System.out.println("Mặc đồ");

    }
}
