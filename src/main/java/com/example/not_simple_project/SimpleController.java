package com.example.not_simple_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/api")
public class SimpleController {

    private final MapRepository mapRepository;

    @Autowired
    public SimpleController(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @PostMapping("/put")
    public ResponseEntity<?> putValue(@RequestParam String key,
                                      @RequestParam String value) {
        mapRepository.put(key, value);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/get/{key}")
    public ResponseEntity<Object> getValue(@PathVariable String key) {
        String result = mapRepository.get(key).orElse(null);
        if (Objects.equals(result, null)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(mapRepository.get(key));
    }
}
