package com.example.not_simple_project;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


@Repository
@NoArgsConstructor
@AllArgsConstructor
public class MapRepository {
    private final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    public void put(String key, String value) {
        map.put(key, value);
    }

    public String get(String key) {
        return map.getOrDefault(key, "empty");
    }
}
