package com.neki.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModel {

  @ApiModelProperty(example = "1")
  private Integer id;
}
