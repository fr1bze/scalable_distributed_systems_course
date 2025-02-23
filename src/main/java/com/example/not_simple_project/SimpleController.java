package com.example.not_simple_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class SimpleController {

    private final MapRepository mapRepository;

    @Autowired
    public SimpleController(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @PostMapping("/put")
    public String putValue(@RequestParam String key, @RequestParam String value) {
        mapRepository.put(key, value);
        return "Saved: " + key + " -> " + value;
    }

    @GetMapping("/get/{key}")
    public String getValue(@PathVariable String key) {
        return mapRepository.get(key);
    }
}
