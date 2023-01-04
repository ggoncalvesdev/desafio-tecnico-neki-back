package com.neki.domain.dto;

import com.neki.domain.model.UserSkill;
import java.io.Serializable;
import lombok.Data;

@Data
public class UserSkillDTOPut implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private Integer knowledgeLevel;

  public UserSkillDTOPut() {}

  public UserSkillDTOPut(UserSkill userSkill) {
    id = userSkill.getId();
    knowledgeLevel = userSkill.getKnowledgeLevel();
  }
}
