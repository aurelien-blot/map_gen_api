package com.castruche.map_gen_api.controller.map;

import com.castruche.map_gen_api.dto.map.MapDto;
import com.castruche.map_gen_api.dto.map.SettingsRequestDto;
import com.castruche.map_gen_api.service.map.MapService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.castruche.map_gen_api.controller.ConstantUrl.MAP;

@RestController
@RequestMapping(MAP)
public class MapController {

    private MapService mapService;
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping()
    public MapDto generate(@RequestBody SettingsRequestDto settingsRequestDto) {
        return mapService.generate(settingsRequestDto);
    }



}
