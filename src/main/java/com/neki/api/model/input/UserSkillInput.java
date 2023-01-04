package com.neki.api.model.input;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSkillInput {

  private Integer knowledgeLevel;
  private Date createdAt;
  private Date updatedAt;
  private UserIdInput user;
  private SkillIdInput skill;
}
