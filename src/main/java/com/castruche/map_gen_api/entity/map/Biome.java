package com.castruche.map_gen_api.entity.map;

import com.castruche.map_gen_api.entity.AbstractEntity;
import jakarta.persistence.Entity;

@Entity
public class Biome extends AbstractEntity {

        private String technicalName;
        private String name;
        private String color;
        private Integer ordre;

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }
}
