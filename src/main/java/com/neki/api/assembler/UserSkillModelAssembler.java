package com.neki.api.assembler;

import com.neki.api.model.UserSkillModel;
import com.neki.domain.model.UserSkill;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSkillModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public UserSkillModel toModel(UserSkill userSkill) {
    return modelMapper.map(userSkill, UserSkillModel.class);
  }

  public List<UserSkillModel> toCollectionModel(List<UserSkill> user) {
    return user
      .stream()
      .map(userSkill -> toModel(userSkill))
      .collect(Collectors.toList());
  }
}
