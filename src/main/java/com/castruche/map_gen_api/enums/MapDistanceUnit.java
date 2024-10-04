package com.castruche.map_gen_api.enums;

public enum MapDistanceUnit {

    PIXELS("px"),
    CENTIMETERS("cm"),
    METERS("m"),
    KILOMETERS("km");

    private String unit;

    MapDistanceUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

}
