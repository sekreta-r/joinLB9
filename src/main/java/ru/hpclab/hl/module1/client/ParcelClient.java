package ru.hpclab.hl.module1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.hpclab.hl.module1.dto.ParcelDTO;
import org.springframework.beans.factory.annotation.Value;


import lombok.RequiredArgsConstructor;
import ru.hpclab.hl.module1.service.statistics.ObservabilityService;

@Component
@RequiredArgsConstructor
public class ParcelClient {

    @Value("${core.service.host}")
    private String coreServiceHost;

    @Value("${core.service.port}")
    private String coreServicePort;

    private final RestTemplate restTemplate;


    private final ObservabilityService observabilityService;

    public ParcelDTO getById(Long parcelId) {

        String metric = getClass().getSimpleName() + ":getById";
        observabilityService.start(metric);

        String url = "http://" + coreServiceHost + ":" + coreServicePort + "/parcels/" + parcelId;
        ParcelDTO result = restTemplate.getForObject(url, ParcelDTO.class);

        observabilityService.stop(metric);
        return result;
    }
}
