package test4;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository{
    @Override
    public Person getPersonByName(String name) {
        return new Person(name);
    }
}
