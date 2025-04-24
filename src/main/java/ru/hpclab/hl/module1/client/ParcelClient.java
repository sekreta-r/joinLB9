package ru.hpclab.hl.module1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.hpclab.hl.module1.dto.ParcelDTO;
import org.springframework.beans.factory.annotation.Value;

@Component
public class ParcelClient {
    @Value("${core.service.host}")
    private String coreServiceHost;

    @Value("${core.service.port}")
    private String coreServicePort;

    private final RestTemplate restTemplate;

    public ParcelClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ParcelDTO getById(Long parcelId) {
        String url = "http://" + coreServiceHost + ":" + coreServicePort + "/parcels/" + parcelId;
        return restTemplate.getForObject(url, ParcelDTO.class);
    }
}
