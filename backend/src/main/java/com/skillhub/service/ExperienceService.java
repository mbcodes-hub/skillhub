package com.skillhub.service;

import com.skillhub.domain.Experience;
import com.skillhub.dto.ExperienceDto;
import com.skillhub.mapper.ExperienceMapper;
import com.skillhub.mapper.UserMapperHelper;
import com.skillhub.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository repository;
    private final ExperienceMapper mapper;
    private final UserMapperHelper userMapperHelper;

    public List<ExperienceDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public ExperienceDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow(() -> new RuntimeException("Not found")));
    }

    public List<Experience> findCurrentJobsByUserId(Long userId) {
        return repository.findByUserIdAndCurrentJobTrue(userId);
    }

    public ExperienceDto create(ExperienceDto dto) {
        Experience saved = repository.save(mapper.toEntity(dto, userMapperHelper));
        return mapper.toDto(saved);
    }

    public ExperienceDto update(Long id, ExperienceDto dto) {
        Experience existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        Experience updated = mapper.toEntity(dto, userMapperHelper);
        updated.setId(existing.getId());
        return mapper.toDto(repository.save(updated));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
