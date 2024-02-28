package ua.larr4k.test.asin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.larr4k.test.service.StatisticsService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/byDateRange")
    public List<Statistics> getStatisticsByDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return statisticsService.getStatisticsByDateRange(startDate, endDate);
    }

    @GetMapping("/byAsin")
    public List<Statistics> getStatisticsByAsin(@RequestParam String asin) {
        return statisticsService.getStatisticsByAsin(asin);
    }


}
