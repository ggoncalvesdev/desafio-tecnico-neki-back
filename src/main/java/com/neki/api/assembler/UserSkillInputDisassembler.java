package com.neki.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neki.api.model.input.SkillLevelInput;
import com.neki.api.model.input.UserSkillInput;
import com.neki.domain.model.UserSkill;

@Component
public class UserSkillInputDisassembler {

  @Autowired
  private ModelMapper modelMapper;

  public UserSkill toDomainObject(UserSkillInput userSkillInput) {
    return modelMapper.map(userSkillInput, UserSkill.class);
  }

  public void copyToDomainObject(
    UserSkillInput userSkillInput,
    UserSkill userSkill
  ) {
    modelMapper.map(userSkillInput, userSkill);
  }
  
  public void copyToDomainObject(
    SkillLevelInput skillLevelInput,
    UserSkill userSkill
    ) {
    modelMapper.map(skillLevelInput, userSkill);
  }
}
