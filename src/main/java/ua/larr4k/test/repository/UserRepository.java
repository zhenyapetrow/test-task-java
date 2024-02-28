package ua.larr4k.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.larr4k.test.user.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}