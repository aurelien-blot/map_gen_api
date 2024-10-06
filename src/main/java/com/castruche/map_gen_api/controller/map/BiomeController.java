package com.castruche.map_gen_api.controller.map;

import com.castruche.map_gen_api.dto.map.BiomeLightDto;
import com.castruche.map_gen_api.service.map.BiomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.castruche.map_gen_api.controller.ConstantUrl.BIOME;

@RestController
@RequestMapping(BIOME)
public class BiomeController {

    private BiomeService biomeService;
    public BiomeController(BiomeService biomeService) {
        this.biomeService = biomeService;
    }

    @GetMapping()
    public List<BiomeLightDto> selectAll() {
        return biomeService.getAllDtoLight();
    }



}
