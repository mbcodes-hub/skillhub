package com.skillhub.controller;


import com.skillhub.dto.SkillDto;
import com.skillhub.enums.SkillLevel;
import com.skillhub.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping
    public ResponseEntity<SkillDto> create(@RequestBody SkillDto dto) {
        return ResponseEntity.ok(skillService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<SkillDto>> getAll() {
        return ResponseEntity.ok(skillService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(skillService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillDto>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(skillService.getByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillDto> update(@PathVariable Long id, @RequestBody SkillDto dto) {
        return ResponseEntity.ok(skillService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        skillService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<List<SkillDto>> getByLevel(@PathVariable SkillLevel level) {
        return ResponseEntity.ok(skillService.getByLevel(level));
    }

    @GetMapping("/user/{userId}/level/{level}")
    public ResponseEntity<List<SkillDto>> getByUserIdAndLevel(
            @PathVariable Long userId,
            @PathVariable SkillLevel level) {
        return ResponseEntity.ok(skillService.getByUserIdAndLevel(userId, level));
    }
}
