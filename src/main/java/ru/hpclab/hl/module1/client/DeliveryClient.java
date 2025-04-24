package ru.hpclab.hl.module1.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.hpclab.hl.module1.dto.DeliveryDTO;
import org.springframework.beans.factory.annotation.Value;

@Component
public class DeliveryClient {
    @Value("${core.service.host}")
    private String coreServiceHost;

    @Value("${core.service.port}")
    private String coreServicePort;

    private final RestTemplate restTemplate;

    public DeliveryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DeliveryDTO[] getByCourierId(Long courierId) {
        String url = "http://" + coreServiceHost + ":" + coreServicePort + "/deliveries/by-courier/" + courierId;
        return restTemplate.getForObject(url, DeliveryDTO[].class);
    }
    public DeliveryDTO[] getAllDeliveries() {
        String url = "http://" + coreServiceHost + ":" + coreServicePort + "/deliveries";
        return restTemplate.getForObject(url, DeliveryDTO[].class);
    }
}
