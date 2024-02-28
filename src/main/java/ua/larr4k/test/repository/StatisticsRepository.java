package ua.larr4k.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.larr4k.test.asin.Statistics;

import java.time.LocalDate;
import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, Long> {

    List<Statistics> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Statistics> findByAsin(String asin);

}
