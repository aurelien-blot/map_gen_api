package com.castruche.map_gen_api.service.map;

import com.castruche.map_gen_api.dao.map.MapRepository;
import com.castruche.map_gen_api.dto.map.MapDto;
import com.castruche.map_gen_api.entity.map.Map;
import com.castruche.map_gen_api.formatter.map.MapFormatter;
import com.castruche.map_gen_api.service.GenericService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class MapService extends GenericService<Map, MapDto, MapDto> {

    private static final Logger logger = LogManager.getLogger(MapService.class);

    private MapRepository mapRepository;
    private MapFormatter mapFormatter;
    public MapService(MapRepository mapRepository, MapFormatter mapFormatter) {
        super(mapRepository, mapFormatter);
        this.mapRepository = mapRepository;
        this.mapFormatter = mapFormatter;
    }
    
}
