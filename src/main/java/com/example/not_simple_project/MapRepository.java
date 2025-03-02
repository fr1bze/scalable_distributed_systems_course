package com.example.not_simple_project;

import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Repository
public class MapRepository {
    private final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(map.getOrDefault(key, null));
    }
}
