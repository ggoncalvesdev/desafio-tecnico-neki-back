package com.neki.domain.exception;

public class SkillNaoEncontradaException
  extends EntidadeNaoEncontradaException {

  private static final long serialVersionUID = 1L;

  public SkillNaoEncontradaException(String mensagem) {
    super(mensagem);
  }

  public SkillNaoEncontradaException(Integer skillId) {
    this(
      String.format("Não existe um cadastro de skill com código %d", skillId)
    );
  }
}
