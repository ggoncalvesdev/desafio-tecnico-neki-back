package com.neki.api.model;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSkillModel {

  private Integer id;
  private Integer KnowledgeLevel;
  private Date CreatedAt;
  private Date UpdatedAt;
  private UserModel user;
  private SkillModel skill;
}
