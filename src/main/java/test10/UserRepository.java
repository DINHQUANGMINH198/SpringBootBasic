package test10;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    public List<User> findByUsername(String username);
    public  List<User> findByPassword(String password);
}