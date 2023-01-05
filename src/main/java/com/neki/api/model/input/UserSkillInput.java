package com.neki.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSkillInput {

  @ApiModelProperty(example = "1")
  private Integer knowledgeLevel;

  @ApiModelProperty(example = "2023-01-04")
  private Date createdAt;

  @ApiModelProperty(example = "2023-01-04")
  private Date updatedAt;

  @ApiModelProperty(example = "User Id")
  private UserIdInput user;

  @ApiModelProperty(example = "Skill Id")
  private SkillIdInput skill;
}
