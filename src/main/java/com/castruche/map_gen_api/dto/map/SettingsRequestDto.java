package com.castruche.map_gen_api.dto.map;

import com.castruche.map_gen_api.enums.MapDistanceUnit;

public class SettingsRequestDto {

    private Double height;
    private Double width;
    private MapDistanceUnit unit;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public MapDistanceUnit getUnit() {
        return unit;
    }

    public void setUnit(MapDistanceUnit unit) {
        this.unit = unit;
    }
}
