package ua.larr4k.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.larr4k.test.asin.StatisticsUpdater;

import java.io.IOException;

@Component
public class StatisticsUpdateScheduler {

    private final StatisticsUpdater statisticsUpdater;

    public StatisticsUpdateScheduler(StatisticsUpdater statisticsUpdater) {
        this.statisticsUpdater = statisticsUpdater;
    }

    @Scheduled(fixedRate = 300000)
    @Transactional
    public void updateStatistics() throws IOException {
        statisticsUpdater.updateStatisticsFromFile("test_report.json");
    }
}