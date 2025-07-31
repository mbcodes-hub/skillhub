package com.skillhub.controller;


import com.skillhub.dto.ProjectDto;
import com.skillhub.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDto> create(@RequestBody ProjectDto dto) {
        ProjectDto created = projectService.create(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll() {
        return ResponseEntity.ok(projectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> update(@PathVariable Long id, @RequestBody ProjectDto dto) {
        return ResponseEntity.ok(projectService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProjectDto>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.getByUserId(userId));
    }
}
