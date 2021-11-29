package test2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {

    Outfit outfit;

    // Spring sẽ inject outfit thông qua Constructor đầu tiên
    // Ngoài ra, nó sẽ tìm Bean có @Qualifier("vest") trong context để ịnject
    public Person(@Qualifier("vest") Outfit outfit) {
        this.outfit = outfit;
    }
}
