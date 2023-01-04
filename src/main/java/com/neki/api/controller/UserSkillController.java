package com.neki.api.controller;

import com.neki.domain.dto.UserSkillDTOPut;
import com.neki.domain.dto.UserSkillDTORequest;
import com.neki.domain.dto.UserSkillDTOResponse;
import com.neki.domain.model.UserSkill;
import com.neki.domain.service.UserSkillService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/userSkills")
public class UserSkillController {

  @Autowired
  private UserSkillService userSkillService;

  @GetMapping("/{userSkillId}")
  public ResponseEntity<UserSkillDTOResponse> findById(
    @PathVariable Integer userSkillId
  ) {
    UserSkill userSkill = userSkillService.findById(userSkillId);
    return ResponseEntity.ok().body(new UserSkillDTOResponse(userSkill));
  }

  @GetMapping
  public ResponseEntity<List<UserSkill>> findAll() {
    List<UserSkill> list = userSkillService.findAll();
    return ResponseEntity.ok().body(list);
  }

  @PostMapping
  public ResponseEntity<Void> create(
    @RequestBody UserSkillDTORequest userSkillDto
  ) {
    UserSkill userSkill = userSkillService.insert(userSkillDto);
    URI uri = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(userSkill.getId())
      .toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping("/{userSkillId}")
  public ResponseEntity<Void> update(
    @Valid @RequestBody UserSkillDTOPut objDto,
    @PathVariable Integer userSkillId
  ) {
    UserSkill userSkill = userSkillService.fromDTO(objDto);
    userSkill.setId(userSkillId);
    userSkill = userSkillService.update(userSkill);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{userSkillId}")
  public ResponseEntity<Void> delete(@PathVariable Integer userSkillId) {
    userSkillService.delete(userSkillId);
    return ResponseEntity.noContent().build();
  }
}
