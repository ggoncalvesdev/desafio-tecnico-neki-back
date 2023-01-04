package com.neki.domain.service;

import com.neki.domain.dto.UserSkillDTOPut;
import com.neki.domain.dto.UserSkillDTORequest;
import com.neki.domain.exception.UserSkillNaoEncontradoException;
import com.neki.domain.model.UserSkill;
import com.neki.domain.repository.SkillRepository;
import com.neki.domain.repository.UserRepository;
import com.neki.domain.repository.UserSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillService {

  @Autowired
  private UserSkillRepository userSkillRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private SkillRepository skillRepository;

  public UserSkill findById(Integer id) {
    Optional<UserSkill> userSkill = userSkillRepository.findById(id);
    return userSkill.orElseThrow(() ->
      new ObjectNotFoundException(
        "Não foi possível encontrar a skill do tipo: " +
        UserSkill.class.getName(),
        null
      )
    );
  }

  public List<UserSkill> findAll() {
    return userSkillRepository.findAll();
  }

  @Transactional
  public UserSkill save(UserSkill userSkill) {
    return userSkillRepository.save(userSkill);
  }

  public UserSkill insert(UserSkillDTORequest userSkillDTO) {
    UserSkill userSkill = new UserSkill();
    userSkill.setUser(userRepository.getById(userSkillDTO.getIdUser()));
    userSkill.setSkill(skillRepository.getById(userSkillDTO.getIdSkill()));
    userSkill.setKnowledgeLevel(userSkillDTO.getKnowledgeLevel());
    return userSkillRepository.save(userSkill);
  }

  public UserSkill update(UserSkill userSkill) {
    UserSkill newUserSkill = findById(userSkill.getId());
    updateData(newUserSkill, userSkill);
    return userSkillRepository.save(newUserSkill);
  }

  private void updateData(UserSkill newUserSkill, UserSkill userSkill) {
    newUserSkill.setKnowledgeLevel(userSkill.getKnowledgeLevel());
  }

  public void delete(Integer id) {
    findById(id);
    userSkillRepository.deleteById(id);
  }

  public UserSkill fromDTO(UserSkillDTOPut userSkillDTO) {
    return new UserSkill(
      userSkillDTO.getId(),
      null,
      null,
      userSkillDTO.getKnowledgeLevel()
    );
  }

  public UserSkill buscarOuFalhar(Integer userSkillId) {
    return userSkillRepository
      .findById(userSkillId)
      .orElseThrow(() -> new UserSkillNaoEncontradoException(userSkillId));
  }
}
