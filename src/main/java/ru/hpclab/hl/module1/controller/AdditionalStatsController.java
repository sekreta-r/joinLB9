package ru.hpclab.hl.module1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.hpclab.hl.module1.dto.CourierStatsDTO;
import ru.hpclab.hl.module1.service.CourierStatsService;

import java.util.List;

@RestController
@RequestMapping("/additional/stats")
@RequiredArgsConstructor
public class AdditionalStatsController {

    private final CourierStatsService courierStatsService;

    @GetMapping("/couriers")
    public List<CourierStatsDTO> getAllCourierStats() {
        return courierStatsService.getStatsForAllCouriers();
    }
}
