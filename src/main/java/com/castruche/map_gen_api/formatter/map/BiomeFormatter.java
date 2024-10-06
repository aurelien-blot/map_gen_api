package com.castruche.map_gen_api.formatter.map;

import com.castruche.map_gen_api.dto.map.BiomeDto;
import com.castruche.map_gen_api.dto.map.BiomeLightDto;
import com.castruche.map_gen_api.dto.map.MapDto;
import com.castruche.map_gen_api.entity.map.Biome;
import com.castruche.map_gen_api.entity.map.Map;
import com.castruche.map_gen_api.formatter.IFormatter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiomeFormatter implements IFormatter<Biome, BiomeDto, BiomeLightDto> {

    @Override
    public BiomeDto entityToDto(Biome entity) {
        if(entity == null){
            return null;
        }
        BiomeDto biomeDto = new BiomeDto();
        biomeDto.setId(entity.getId());
        biomeDto.setTechnicalName(entity.getTechnicalName());
        biomeDto.setName(entity.getName());
        biomeDto.setColor(entity.getColor());
        return biomeDto;
    }

    @Override
    public BiomeLightDto entityToLightDto(Biome entity) {
        if(entity == null){
            return null;
        }
        BiomeLightDto biomeDto = new BiomeLightDto();
        biomeDto.setId(entity.getId());
        biomeDto.setTechnicalName(entity.getTechnicalName());
        biomeDto.setName(entity.getName());
        biomeDto.setColor(entity.getColor());
        return biomeDto;
    }

    @Override
    public Biome dtoToEntity(BiomeDto dto) {
        Biome biome = new Biome();
        biome.setId(dto.getId());
        biome.setTechnicalName(dto.getTechnicalName());
        biome.setName(dto.getName());
        biome.setColor(dto.getColor());

        return biome;
    }

    @Override
    public List<BiomeDto> entityToDto(List<Biome> biomes) {
        return IFormatter.super.entityToDto(biomes);
    }

    @Override
    public List<BiomeLightDto> entityToLightDto(List<Biome> biomes) {
        return IFormatter.super.entityToLightDto(biomes);
    }

}
