package ua.larr4k.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ua.larr4k.test.user.User;

import java.util.Optional;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(mongoTemplate.findOne(
                Query.query(Criteria.where("username").is(username)),
                User.class));
    }

    @Override
    public <S extends User> S save(S entity) {
        return mongoTemplate.save(entity);
    }


}