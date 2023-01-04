package com.neki.api.controller;

import com.neki.api.assembler.SkillInputDisassembler;
import com.neki.api.assembler.SkillModelAssembler;
import com.neki.api.model.SkillModel;
import com.neki.api.model.input.SkillInput;
import com.neki.domain.exception.NegocioException;
import com.neki.domain.exception.SkillNaoEncontradaException;
import com.neki.domain.model.Skill;
import com.neki.domain.repository.SkillRepository;
import com.neki.domain.service.SkillService;
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
@RequestMapping(value = "/skills")
public class SkillController {

  @Autowired
  private SkillService skillService;

  @Autowired
  private SkillRepository skillRepository;

  @Autowired
  private SkillModelAssembler skillModelAssembler;

  @Autowired
  private SkillInputDisassembler skillInputDisassembler;

  @GetMapping
  public List<SkillModel> findAll() {
    return skillModelAssembler.toCollectionModel(skillRepository.findAll());
  }

  @GetMapping("/{skillId}")
  public SkillModel findById(@PathVariable Integer skillId) {
    Skill skill = skillService.buscarOuFalhar(skillId);
    return skillModelAssembler.toModel(skill);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SkillModel create(@RequestBody @Valid SkillInput skillInput) {
    try {
      Skill skill = skillInputDisassembler.toDomainObject(skillInput);

      return skillModelAssembler.toModel(skillService.save(skill));
    } catch (SkillNaoEncontradaException e) {
      throw new NegocioException(e.getMessage());
    }
  }

  @PutMapping("/{skillId}")
  public SkillModel update(
    @PathVariable Integer skillId,
    @RequestBody @Valid SkillInput skillInput
  ) {
    Skill skillAtual = skillService.buscarOuFalhar(skillId);

    skillInputDisassembler.copyToDomainObject(skillInput, skillAtual);
    skillAtual = skillService.save(skillAtual);

    return skillModelAssembler.toModel(skillAtual);
  }

  @DeleteMapping("/{skillId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remover(@PathVariable Integer skillId) {
    skillService.delete(skillId);
  }
}
