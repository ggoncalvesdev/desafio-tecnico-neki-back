package com.neki.api.assembler;

import com.neki.api.model.UserModel;
import com.neki.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModelAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public UserModel toModel(Usuario user) {
    return modelMapper.map(user, UserModel.class);
  }
}
