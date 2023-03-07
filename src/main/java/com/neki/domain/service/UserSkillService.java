package com.neki.domain.service;

import com.neki.domain.exception.UserSkillNaoEncontradoException;
import com.neki.domain.model.UserSkill;
import com.neki.domain.repository.UserSkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSkillService {

  private static final String MSG_SKILL_NAO_ENCONTRADA =
  "Não foi possível encontrar a skill do tipo: ";

  @Autowired
  private UserSkillRepository userSkillRepository;

  public UserSkill findById(Integer id) {
    Optional<UserSkill> userSkill = userSkillRepository.findById(id);
    return userSkill.orElseThrow(() ->
      new ObjectNotFoundException(
        MSG_SKILL_NAO_ENCONTRADA +
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

  public UserSkill findBySkillFromUser(Integer user_id) {
    return userSkillRepository.buscarSkillUsuario(user_id);
  }

  public UserSkill buscarOuFalhar(Integer userSkillId) {
    return userSkillRepository
      .findById(userSkillId)
      .orElseThrow(() -> new UserSkillNaoEncontradoException(userSkillId));
  }
}
