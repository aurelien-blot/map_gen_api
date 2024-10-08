package com.castruche.map_gen_api.service.map;

import com.castruche.map_gen_api.dao.map.BiomeRepository;
import com.castruche.map_gen_api.dto.map.BiomeDto;
import com.castruche.map_gen_api.dto.map.BiomeLightDto;
import com.castruche.map_gen_api.entity.map.Biome;
import com.castruche.map_gen_api.formatter.map.BiomeFormatter;
import com.castruche.map_gen_api.service.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiomeService extends GenericService<Biome, BiomeDto, BiomeLightDto> {

    private static final Logger logger = LogManager.getLogger(BiomeService.class);

    private BiomeRepository biomeRepository;
    private BiomeFormatter biomeFormatter;
    public BiomeService(BiomeRepository biomeRepository, BiomeFormatter biomeFormatter) {
        super(biomeRepository, biomeFormatter);
        this.biomeRepository = biomeRepository;
        this.biomeFormatter = biomeFormatter;
    }

    public BiomeDto findByTechnicalName(String technicalName) {
        Biome entity = biomeRepository.findByTechnicalName(technicalName);
        return biomeFormatter.entityToDto(entity);
    }

    public List<BiomeLightDto> getAllDtoLight() {
        List<Biome> entities = this.getAll();
        entities.sort((Biome b1, Biome b2) -> b1.getOrdre().compareTo(b2.getOrdre()));
        return biomeFormatter.entityToLightDto(entities);
    }

    
}
