package test1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
//    Đánh dấu thuộc tính Outfit của Person bởi Annotation @Autowired.
//    Điều này nói với Spring Boot hãy tự inject (tiêm) một instance của Outfit vào thuộc tính này khi khởi tạo Person.
    @Autowired
    Outfit outfit;

    public Person(Outfit outfit) {
        this.outfit = outfit;
    }
}
