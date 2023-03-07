package com.neki.domain.service;

import com.neki.domain.exception.EntidadeEmUsoException;
import com.neki.domain.exception.SkillNaoEncontradaException;
import com.neki.domain.model.Skill;
import com.neki.domain.repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

  private static final String MSG_SKILL_EM_USO = "Skill de código %d não pode ser removida, pois está em uso";

  @Autowired
  private SkillRepository skillRepository;

  public Skill findById(Integer skillId) {
    Optional<Skill> obj = skillRepository.findById(skillId);
    return obj.orElseThrow(() -> new SkillNaoEncontradaException(skillId));
  }

  public List<Skill> findAll() {
    return skillRepository.findAll();
  }

  @Transactional
  public Skill save(Skill skill) {
    return skillRepository.save(skill);
  }

  @Transactional
  public void delete(Integer skillId) {
    try {
      skillRepository.deleteById(skillId);
      skillRepository.flush();
    } catch (EmptyResultDataAccessException e) {
      throw new SkillNaoEncontradaException(skillId);
    } catch (DataIntegrityViolationException e) {
      throw new EntidadeEmUsoException(String.format(MSG_SKILL_EM_USO, skillId));
    }
  }

  public Skill buscarOuFalhar(Integer skillId) {
    return skillRepository.findById(skillId).orElseThrow(() -> new SkillNaoEncontradaException(skillId));
  }
}
