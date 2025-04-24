package ru.hpclab.hl.module1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryDTO {
    private Long id;
    private Long parcelId;
    private Long courierId;
    private LocalDate deliveryDate;
    private String status;
}
