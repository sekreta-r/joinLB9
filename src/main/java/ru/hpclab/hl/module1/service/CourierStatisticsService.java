package ru.hpclab.hl.module1.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.hpclab.hl.module1.service.cache.CourierCache;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CourierStatisticsService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Async("applicationTaskExecutor")
    @Scheduled(fixedRateString = "${service.courier-statistics.delay:10000}")
    public void logCourierCacheSizeAsync() {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.println(timestamp + " [" + Thread.currentThread().getName() + "] Courier cache size: " + CourierCache.size());
    }
}
