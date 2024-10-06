package com.castruche.map_gen_api.dto.map;


import com.castruche.map_gen_api.dto.AbstractDto;

public class MapDto extends AbstractDto {

    private Long heightPx;
    private Long widthPx;
    private String [][] map;

    public Long getHeightPx() {
        return heightPx;
    }

    public void setHeightPx(Long heightPx) {
        this.heightPx = heightPx;
    }

    public Long getWidthPx() {
        return widthPx;
    }

    public void setWidthPx(Long widthPx) {
        this.widthPx = widthPx;
    }

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }
}
