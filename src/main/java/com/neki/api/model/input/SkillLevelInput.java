package com.neki.api.model.input;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkillLevelInput {

  @ApiModelProperty(example = "1")
  private Integer knowledgeLevel;
}
