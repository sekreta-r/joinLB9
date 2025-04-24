package ru.hpclab.hl.module1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.hl.module1.dto.CourierStatsDTO;
import ru.hpclab.hl.module1.service.CourierStatsService;


import ru.hpclab.hl.module1.service.statistics.ObservabilityService;

import java.util.List;

@RestController
@RequestMapping("/additional/stats")
@RequiredArgsConstructor
public class AdditionalStatsController {

    private final CourierStatsService courierStatsService;


    private final ObservabilityService observabilityService;

    @GetMapping("/couriers")
    public List<CourierStatsDTO> getAllCourierStats() {

        String metric = getClass().getSimpleName() + ":getAllCourierStats";
        observabilityService.start(metric);

        List<CourierStatsDTO> result = courierStatsService.getStatsForAllCouriers();

        observabilityService.stop(metric);
        return result;
    }
}
