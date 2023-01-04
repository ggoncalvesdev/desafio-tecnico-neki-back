package com.neki.domain.repository;

import com.neki.domain.model.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository
  extends JpaRepository<UserSkill, Integer> {}
