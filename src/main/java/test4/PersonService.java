package test4;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person getRandomPerson(){
        // Random 1 cái tên độ dài 10
        String name = randomPersonName(10);

        // Gọi xuông tầng repository để query lấy một người tên là "name" trong database
        return personRepository.getPersonByName(name);
    }

    public String randomPersonName(int length) {
        // Random một string có độ dài quy định
        // Sử dụng thư viện Apache Common Lang
        return RandomStringUtils.randomAlphanumeric(length).toLowerCase();
    }
}
