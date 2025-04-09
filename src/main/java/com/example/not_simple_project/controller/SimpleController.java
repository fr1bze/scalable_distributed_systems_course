package com.example.not_simple_project.controller;

import com.example.not_simple_project.entity.EntityKeyValue;
import com.example.not_simple_project.service.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SimpleController {

    @Autowired
    private final MapService mapService;

    @PostMapping
    public ResponseEntity<EntityKeyValue> saveData(@RequestBody EntityKeyValue data) {
        return ResponseEntity.ok(mapService.save(data));
    }

    @GetMapping("/{key}")
    public ResponseEntity<EntityKeyValue> getData(@PathVariable String key) {
        return mapService.getValue(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
