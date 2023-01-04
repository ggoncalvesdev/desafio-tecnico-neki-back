package com.neki.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SkillModel {

  private Integer id;

  private String name;
  private String version;
  private String description;
  private String imageUrl;
}
