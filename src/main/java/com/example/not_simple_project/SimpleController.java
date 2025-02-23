package com.example.not_simple_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> putValue(@RequestBody RequestDTO request) {
        String key = request.getKey();
        String value = request.getValue();
        mapRepository.put(key, value);

        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("/get/{key}")
    public String getValue(@PathVariable String key) {
        return mapRepository.get(key);
    }
}
