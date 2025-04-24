package ru.hpclab.hl.module1.dto;

import lombok.Data;

@Data
public class CourierDTO {
    private Long id;
    private String fullName;
    private String transport;
    private String workZone;
}
