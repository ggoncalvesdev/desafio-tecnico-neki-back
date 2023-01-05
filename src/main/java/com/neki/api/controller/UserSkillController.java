package com.neki.api.controller;

import com.neki.api.assembler.UserSkillInputDisassembler;
import com.neki.api.assembler.UserSkillModelAssembler;
import com.neki.api.model.UserSkillModel;
import com.neki.api.model.input.UserSkillInput;
import com.neki.domain.exception.NegocioException;
import com.neki.domain.exception.UserSkillNaoEncontradoException;
import com.neki.domain.model.UserSkill;
import com.neki.domain.repository.UserSkillRepository;
import com.neki.domain.service.UserSkillService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userSkills")
public class UserSkillController {

  @Autowired
  private UserSkillService userSkillService;

  @Autowired
  private UserSkillRepository userSkillRepository;

  @Autowired
  private UserSkillModelAssembler userSkillModelAssembler;

  @Autowired
  private UserSkillInputDisassembler userSkillInputDisassembler;

  @GetMapping
  public List<UserSkillModel> findAll() {
    return userSkillModelAssembler.toCollectionModel(
      userSkillRepository.findAll()
    );
  }

  @GetMapping("/{userSkillId}")
  public UserSkillModel findById(@PathVariable Integer userSkillId) {
    UserSkill userSkill = userSkillService.buscarOuFalhar(userSkillId);
    return userSkillModelAssembler.toModel(userSkill);
  }

  @GetMapping("user/{user_id}")
  public UserSkillModel findByUserId(@PathVariable Integer user_id) {
    UserSkill userSkill = userSkillService.findBySkillFromUser(user_id);
    return userSkillModelAssembler.toModel(userSkill);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserSkillModel create(
    @RequestBody @Valid UserSkillInput userSkillInput
  ) {
    try {
      UserSkill userSkill = userSkillInputDisassembler.toDomainObject(
        userSkillInput
      );

      return userSkillModelAssembler.toModel(userSkillService.save(userSkill));
    } catch (UserSkillNaoEncontradoException e) {
      throw new NegocioException(e.getMessage());
    }
  }

  @PutMapping("/{userSkillId}")
  public UserSkillModel update(
    @PathVariable Integer userSkillId,
    @RequestBody @Valid UserSkillInput userSkillInput
  ) {
    UserSkill userSkillAtual = userSkillService.buscarOuFalhar(userSkillId);

    userSkillInputDisassembler.copyToDomainObject(
      userSkillInput,
      userSkillAtual
    );
    userSkillAtual = userSkillService.save(userSkillAtual);

    return userSkillModelAssembler.toModel(userSkillAtual);
  }

  @DeleteMapping("/{userSkillId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer userSkillId) {
    userSkillService.delete(userSkillId);
  }
}
