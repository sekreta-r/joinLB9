package ru.hpclab.hl.module1.dto;

import java.time.Month;
import java.util.Map;

public class CourierStatsDTO {
    private String fullName;
    private Map<Month, Double> weightByMonth;

    public CourierStatsDTO() {}

    public CourierStatsDTO(String fullName, Map<Month, Double> weightByMonth) {
        this.fullName = fullName;
        this.weightByMonth = weightByMonth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<Month, Double> getWeightByMonth() {
        return weightByMonth;
    }

    public void setWeightByMonth(Map<Month, Double> weightByMonth) {
        this.weightByMonth = weightByMonth;
    }
}
