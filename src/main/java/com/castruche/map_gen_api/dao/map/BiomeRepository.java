package com.castruche.map_gen_api.dao.map;

import com.castruche.map_gen_api.entity.map.Biome;
import com.castruche.map_gen_api.entity.map.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiomeRepository extends JpaRepository<Biome, Long> {

    Biome findByTechnicalName(String technicalName);
}
