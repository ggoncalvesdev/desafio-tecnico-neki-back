package com.neki.domain.dto;

import lombok.Data;

@Data
public class SkillDTORequest {

  private String name;
  private String version;
  private String description;
  private String imageUrl;
}
