package ua.larr4k.test.mongo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.port}")
    private int port;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoTemplate mongoTemplate() {
        String connectionString = String.format("mongodb://%s:%d", host, port);
        SimpleMongoClientDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(connectionString);
        return new MongoTemplate(mongoDatabaseFactory);
    }
}