package com.skillhub.repository;

import com.skillhub.domain.Skill;
import com.skillhub.enums.SkillLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    List<Skill> findByUserId(Long userId);

    List<Skill> findByLevel(SkillLevel level);

    List<Skill> findByUserIdAndLevel(Long userId, SkillLevel level);

}
