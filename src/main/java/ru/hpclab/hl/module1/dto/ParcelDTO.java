package ru.hpclab.hl.module1.dto;

import lombok.Data;

@Data
public class ParcelDTO {
    private Long id;
    private double weight;
    private String dimensions;
    private String destinationAddress;
}
