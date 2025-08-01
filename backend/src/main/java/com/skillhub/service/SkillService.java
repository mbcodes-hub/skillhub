package com.skillhub.service;


import com.skillhub.domain.Skill;
import com.skillhub.dto.SkillDto;
import com.skillhub.enums.SkillLevel;
import com.skillhub.mapper.SkillMapper;
import com.skillhub.mapper.UserMapperHelper;
import com.skillhub.repository.SkillRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;
    private final UserMapperHelper userMapperHelper;

    public SkillDto create(SkillDto dto) {
        Skill skill = skillMapper.toEntity(dto, userMapperHelper);
        return skillMapper.toDto(skillRepository.save(skill));
    }

    public List<SkillDto> getAll() {
        return skillRepository.findAll().stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }

    public SkillDto getById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + id));
        return skillMapper.toDto(skill);
    }

    public List<SkillDto> getByUserId(Long userId) {
        return skillRepository.findByUserId(userId).stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }

    public SkillDto update(Long id, SkillDto dto) {
        Skill existing = skillRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Skill not found with id: " + id));

        skillMapper.updateEntityFromDto(dto, existing, userMapperHelper);
        return skillMapper.toDto(skillRepository.save(existing));
    }

    public void delete(Long id) {
        if (!skillRepository.existsById(id)) {
            throw new EntityNotFoundException("Skill not found with id: " + id);
        }
        skillRepository.deleteById(id);
    }

    public List<SkillDto> getByLevel(SkillLevel level) {
        return skillRepository.findByLevel(level).stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }

    public List<SkillDto> getByUserIdAndLevel(Long userId, SkillLevel level) {
        return skillRepository.findByUserIdAndLevel(userId, level).stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }
}
