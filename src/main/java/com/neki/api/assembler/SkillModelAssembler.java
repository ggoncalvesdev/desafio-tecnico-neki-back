package com.neki.api.assembler;

import com.neki.api.model.SkillModel;
import com.neki.domain.model.Skill;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public SkillModel toModel(Skill skill) {
    return modelMapper.map(skill, SkillModel.class);
  }

  public List<SkillModel> toCollectionModel(List<Skill> skills) {
    return skills
      .stream()
      .map(skill -> toModel(skill))
      .collect(Collectors.toList());
  }
}
