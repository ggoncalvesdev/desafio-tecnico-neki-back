package com.neki.domain.repository;

import com.neki.domain.model.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, Integer> {
  @Query(
    value = "SELECT user_id, skill_id FROM teste_residencia.user_skill WHERE user_id = :id",
    nativeQuery = true
  )
  public UserSkill buscarSkillUsuario(@Param("id") Integer id);
}
