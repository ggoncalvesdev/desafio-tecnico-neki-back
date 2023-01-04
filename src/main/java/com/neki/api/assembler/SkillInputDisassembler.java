package com.neki.api.assembler;

import com.neki.api.model.input.SkillInput;
import com.neki.domain.model.Skill;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillInputDisassembler {

  @Autowired
  private ModelMapper modelMapper;

  public Skill toDomainObject(SkillInput skillInput) {
    return modelMapper.map(skillInput, Skill.class);
  }

  public void copyToDomainObject(SkillInput skillInput, Skill skill) {
    modelMapper.map(skillInput, skill);
  }
}
