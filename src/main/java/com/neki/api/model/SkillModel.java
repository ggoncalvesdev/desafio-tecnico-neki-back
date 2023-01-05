package com.neki.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkillModel {

  @ApiModelProperty(example = "1")
  private Integer id;

  @ApiModelProperty(example = "Java")
  private String name;

  @ApiModelProperty(example = "11")
  private String version;

  @ApiModelProperty(example = "Intermediário")
  private String description;

  @ApiModelProperty(
    example = "https://logospng.org/download/javascript/logo-javascript-512.png"
  )
  private String imageUrl;
}
