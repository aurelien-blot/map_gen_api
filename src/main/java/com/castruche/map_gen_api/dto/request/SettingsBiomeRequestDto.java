package com.castruche.map_gen_api.dto.request;

import com.castruche.map_gen_api.enums.MapDistanceUnit;

public class SettingsBiomeRequestDto {

    private Long biomeId;
    private Double percentage;
    private Long pixelTotal;

    public Long getBiomeId() {
        return biomeId;
    }

    public void setBiomeId(Long biomeId) {
        this.biomeId = biomeId;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Long getPixelTotal() {
        return pixelTotal;
    }

    public void setPixelTotal(Long pixelTotal) {
        this.pixelTotal = pixelTotal;
    }
}
