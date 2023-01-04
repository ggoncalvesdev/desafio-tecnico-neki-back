package com.neki.domain.dto;

import lombok.Data;

@Data
public class UserSkillDTORequest {

  private Integer idUser;
  private Integer idSkill;
  private Integer knowledgeLevel;
}
