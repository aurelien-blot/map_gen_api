package com.castruche.map_gen_api.service.map;

import com.castruche.map_gen_api.dto.map.BiomeDto;
import com.castruche.map_gen_api.dto.map.MapDto;
import com.castruche.map_gen_api.dto.request.SettingsBiomeRequestDto;
import com.castruche.map_gen_api.dto.request.SettingsRequestDto;
import com.castruche.map_gen_api.service.util.MathService;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Service
public class MapGenerationService  {

    private static final Logger logger = LogManager.getLogger(MapGenerationService.class);

    private BiomeService biomeService;

    public MapGenerationService(BiomeService biomeService) {
        this.biomeService = biomeService;
    }

    @Transactional
    public MapDto generate(SettingsRequestDto settingsRequestDto) {
        settingsRequestDto.setSettingsBiomeList(generateSettingsBiomeListForTest());
        MapDto map = new MapDto();
        map.setHeightPx(settingsRequestDto.getHeightPx());
        map.setWidthPx(settingsRequestDto.getWidthPx());
        map.setMap(fillMapWithBiomes(settingsRequestDto));
        return map;
    }

    private List<SettingsBiomeRequestDto> generateSettingsBiomeListForTest() {
        double[] percents = {0D, 0D, 50D, 50D};

        List<SettingsBiomeRequestDto> list = new ArrayList<>();

        SettingsBiomeRequestDto settingsBiomeRequestDto = new SettingsBiomeRequestDto();
        settingsBiomeRequestDto.setBiomeId(1L);
        settingsBiomeRequestDto.setPercentage(percents[0]);
        list.add(settingsBiomeRequestDto);

        settingsBiomeRequestDto = new SettingsBiomeRequestDto();
        settingsBiomeRequestDto.setBiomeId(2L);
        settingsBiomeRequestDto.setPercentage(percents[1]);
        list.add(settingsBiomeRequestDto);

        settingsBiomeRequestDto = new SettingsBiomeRequestDto();
        settingsBiomeRequestDto.setBiomeId(3L);
        settingsBiomeRequestDto.setPercentage(percents[2]);
        list.add(settingsBiomeRequestDto);

        settingsBiomeRequestDto = new SettingsBiomeRequestDto();
        settingsBiomeRequestDto.setBiomeId(4L);
        settingsBiomeRequestDto.setPercentage(percents[3]);
        list.add(settingsBiomeRequestDto);

        return list;
    }

    private String [][] fillMapWithBiomes(SettingsRequestDto settingsRequestDto) {
        if(settingsRequestDto==null || !settingsRequestDto.isValid()){
            throw new IllegalArgumentException("Invalid settings");
        }
        checkBiomeListValidity(settingsRequestDto.getSettingsBiomeList());

        List<Long> biomesId =  settingsRequestDto.getSettingsBiomeList().stream().map(SettingsBiomeRequestDto::getBiomeId).toList();
        List<BiomeDto> biomeList = biomeService.selectDtoByIdIn(biomesId);
        HashMap<Long, BiomeDto> biomeMap = biomeList.stream().collect(HashMap::new, (m, b) -> m.put(b.getId(), b), HashMap::putAll);

        String [][] map =randomBiomeGeneration(settingsRequestDto, biomeMap);

        return map;
    }

    private void checkBiomeListValidity(List<SettingsBiomeRequestDto> settingsBiomeList) {
        if(settingsBiomeList == null || settingsBiomeList.isEmpty()){
            throw new IllegalArgumentException("Liste des biomes vide");
        }
        if(settingsBiomeList.stream().anyMatch(settingsBiomeRequestDto -> settingsBiomeRequestDto.getBiomeId() == null || settingsBiomeRequestDto.getPercentage() == null)){
            throw new IllegalArgumentException("Liste des biomes invalide");
        }
        if(settingsBiomeList.stream().map(SettingsBiomeRequestDto::getPercentage).mapToDouble(Double::doubleValue).sum() > 100){
            throw new IllegalArgumentException("Liste des biomes > 100%");
        }
    }
    private void fillEmptyPixels(Long totalPixels, List<BiomeDto> biomePixelList) {
        if(biomePixelList.size() < totalPixels){
            BiomeDto emptyBiome = biomeService.findByTechnicalName("ocean");
            int emptyPixels = Math.toIntExact(totalPixels - biomePixelList.size());
            for (int i = 0; i < emptyPixels; i++) biomePixelList.add(emptyBiome);
        }
    }

    private  String [][] randomBiomeGeneration(SettingsRequestDto settingsRequestDto, HashMap<Long, BiomeDto> biomeMap){
        List<BiomeDto> biomePixelList = new ArrayList<>();
        settingsRequestDto.getSettingsBiomeList().forEach(settingsBiomeRequestDto -> {
            if(settingsBiomeRequestDto.getBiomeId()==null || settingsBiomeRequestDto.getPercentage() == null || settingsBiomeRequestDto.getPercentage() <=0){
                return;
            }
            BiomeDto biome = biomeMap.get(settingsBiomeRequestDto.getBiomeId());
            settingsBiomeRequestDto.setPixelTotal(Math.round(settingsRequestDto.getTotalPixels() * settingsBiomeRequestDto.getPercentage() / 100));
            for (int i = 0; i < settingsBiomeRequestDto.getPixelTotal(); i++) biomePixelList.add(biome);
        });

        fillEmptyPixels(settingsRequestDto.getTotalPixels(), biomePixelList);

        Collections.shuffle(biomePixelList);
        String [][] map= new String[settingsRequestDto.getHeightPx().intValue()][settingsRequestDto.getWidthPx().intValue()];

        int index = 0;
        for (int y = 0; y < settingsRequestDto.getWidthPx(); y++) {
            for (int x = 0; x < settingsRequestDto.getHeightPx(); x++) {
                map[x][y] = biomePixelList.get(index++).getColor();
            }
        }
        return map;
    }

    
}
