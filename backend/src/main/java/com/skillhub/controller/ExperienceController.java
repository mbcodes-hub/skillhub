package com.skillhub.controller;

import com.skillhub.domain.Experience;
import com.skillhub.dto.ExperienceDto;
import com.skillhub.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService service;

    @GetMapping
    public ResponseEntity<List<ExperienceDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/user/{userId}/current-jobs")
    public ResponseEntity<List<Experience>> getCurrentJobsByUserId(@PathVariable Long userId) {
        List<Experience> experiences = service.findCurrentJobsByUserId(userId);
        if (experiences.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(experiences);
    }

    @PostMapping
    public ResponseEntity<ExperienceDto> create(@RequestBody ExperienceDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExperienceDto> update(@PathVariable Long id, @RequestBody ExperienceDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
