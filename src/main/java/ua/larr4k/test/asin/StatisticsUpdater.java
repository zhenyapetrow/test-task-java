package ua.larr4k.test.asin;


import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.larr4k.test.repository.StatisticsRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Component
public class StatisticsUpdater {

    private final StatisticsRepository statisticsRepository;
    private final MongoTemplate mongoTemplate;

    public StatisticsUpdater(StatisticsRepository statisticsRepository, MongoTemplate mongoTemplate) {
        this.statisticsRepository = statisticsRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Transactional
    public void updateStatisticsFromFile(String filename) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filename));


        for (String line : lines) {

            String[] parts = line.split(",");
            LocalDate date = LocalDate.parse(parts[0]);
            String asin = parts[1];


            Statistics statistics = new Statistics();
            statistics.setDate(date);
            statistics.setAsin(asin);


            mongoTemplate.save(statistics);
        }
    }
}
