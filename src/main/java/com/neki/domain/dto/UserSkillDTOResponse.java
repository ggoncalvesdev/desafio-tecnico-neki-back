package com.neki.domain.dto;

import com.neki.domain.model.UserSkill;
import lombok.Data;

@Data
public class UserSkillDTOResponse {

  private Integer id;
  private Integer idClient;
  private Integer idSkill;
  private Integer knowledgeLevel;

  public UserSkillDTOResponse(UserSkill userSkill) {
    super();
    this.id = userSkill.getId();
    this.idClient = userSkill.getUser().getId();
    this.idSkill = userSkill.getSkill().getId();
    this.knowledgeLevel = userSkill.getKnowledgeLevel();
  }
}
