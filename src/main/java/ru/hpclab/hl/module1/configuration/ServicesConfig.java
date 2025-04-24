package ru.hpclab.hl.module1.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hpclab.hl.module1.service.CourierStatisticsService;

@Configuration
public class ServicesConfig {

    @Bean
    @ConditionalOnProperty(prefix = "statistics", name = "service", havingValue = "true")
    CourierStatisticsService statisticsService() {
        return new CourierStatisticsService();
    }
}
