package ua.larr4k.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.larr4k.test.asin.Statistics;
import ua.larr4k.test.repository.StatisticsRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<Statistics> getStatisticsByDateRange(LocalDate startDate, LocalDate endDate) {
        return statisticsRepository.findByDateBetween(startDate, endDate);
    }

    public List<Statistics> getStatisticsByAsin(String asin) {
        return statisticsRepository.findByAsin(asin);
    }
}