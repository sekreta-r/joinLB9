package ru.hpclab.hl.module1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.hpclab.hl.module1.dto.DeliveryDTO;
import org.springframework.beans.factory.annotation.Value;


import lombok.RequiredArgsConstructor;
import ru.hpclab.hl.module1.service.statistics.ObservabilityService;

@Component
@RequiredArgsConstructor
public class DeliveryClient {

    @Value("${core.service.host}")
    private String coreServiceHost;

    @Value("${core.service.port}")
    private String coreServicePort;

    private final RestTemplate restTemplate;


    private final ObservabilityService observabilityService;

    public DeliveryDTO[] getByCourierId(Long courierId) {

        String metric = getClass().getSimpleName() + ":getByCourierId";
        observabilityService.start(metric);

        String url = "http://" + coreServiceHost + ":" + coreServicePort + "/deliveries/by-courier/" + courierId;
        DeliveryDTO[] result = restTemplate.getForObject(url, DeliveryDTO[].class);

        observabilityService.stop(metric);
        return result;
    }

    public DeliveryDTO[] getAllDeliveries() {

        String metric = getClass().getSimpleName() + ":getAllDeliveries";
        observabilityService.start(metric);

        String url = "http://" + coreServiceHost + ":" + coreServicePort + "/deliveries";
        DeliveryDTO[] result = restTemplate.getForObject(url, DeliveryDTO[].class);

        observabilityService.stop(metric);
        return result;
    }
}
