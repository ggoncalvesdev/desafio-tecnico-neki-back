package com.neki.api.model;

import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSkillModel {

  @ApiModelProperty(example = "1")
  private Integer id;

  @ApiModelProperty(example = "1")
  private Integer KnowledgeLevel;

  @ApiModelProperty(example = "2023-01-04")
  private Date CreatedAt;

  @ApiModelProperty(example = "2023-01-04")
  private Date UpdatedAt;

  @ApiModelProperty(example = "User Id")
  private UserModel user;

  @ApiModelProperty(example = "Skill Id")
  private SkillModel skill;
}
