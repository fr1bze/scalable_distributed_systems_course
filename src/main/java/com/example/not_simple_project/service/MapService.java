package com.example.not_simple_project.service;

import com.example.not_simple_project.entity.EntityKeyValue;
import com.example.not_simple_project.repository.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapService {
    private final MapRepository mapRepository;
    @Autowired
    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public EntityKeyValue save(EntityKeyValue entity) {
        mapRepository.save(entity);
        return entity;
    }

    public Optional<EntityKeyValue> getValue(String key) {
        return mapRepository.findById(Long.valueOf(key));
    }
}
