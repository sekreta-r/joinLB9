package ru.hpclab.hl.module1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.hpclab.hl.module1.dto.CourierDTO;
import org.springframework.beans.factory.annotation.Value;


import lombok.RequiredArgsConstructor;
import ru.hpclab.hl.module1.service.statistics.ObservabilityService;

@Component
@RequiredArgsConstructor
public class CourierClient {

    @Value("${core.service.host}")
    private String coreServiceHost;

    @Value("${core.service.port}")
    private String coreServicePort;

    private final RestTemplate restTemplate;


    private final ObservabilityService observabilityService;

    public CourierDTO[] getAllCouriers() {

        String metric = getClass().getSimpleName() + ":getAllCouriers";
        observabilityService.start(metric);

        CourierDTO[] result = restTemplate.getForObject("http://" + coreServiceHost + ":" + coreServicePort + "/couriers", CourierDTO[].class);

        observabilityService.stop(metric);
        return result;
    }

    public CourierDTO getCourierById(Long id) {

        String metric = getClass().getSimpleName() + ":getCourierById";
        observabilityService.start(metric);

        String url = "http://" + coreServiceHost + ":" + coreServicePort + "/couriers/" + id;
        CourierDTO result = restTemplate.getForObject(url, CourierDTO.class);

        observabilityService.stop(metric);
        return result;
    }
}
