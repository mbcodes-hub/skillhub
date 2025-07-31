package com.skillhub.service;

import com.skillhub.domain.Project;
import com.skillhub.dto.ProjectDto;
import com.skillhub.mapper.ProjectMapper;
import com.skillhub.mapper.UserMapperHelper;
import com.skillhub.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final UserMapperHelper userMapperHelper;

    public ProjectDto create(ProjectDto dto) {
        Project project = projectMapper.toEntity(dto, userMapperHelper);
        return projectMapper.toDto(projectRepository.save(project));
    }

    public List<ProjectDto> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProjectDto getById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));
        return projectMapper.toDto(project);
    }

    public ProjectDto update(Long id, ProjectDto dto) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + id));

        Project updated = projectMapper.toEntity(dto, userMapperHelper);
        updated.setId(existing.getId());

        return projectMapper.toDto(projectRepository.save(updated));
    }

    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }

    public List<ProjectDto> getByUserId(Long userId) {
        return projectRepository.findByUserId(userId)
                .stream()
                .map(projectMapper::toDto)
                .collect(Collectors.toList());
    }
}
