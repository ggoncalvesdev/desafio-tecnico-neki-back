package com.neki.domain.exception;

public class UserSkillNaoEncontradoException
  extends EntidadeNaoEncontradaException {

  public UserSkillNaoEncontradoException(String mensagem) {
    super(mensagem);
  }

  public UserSkillNaoEncontradoException(Integer userSkillId) {
    this(
      String.format(
        "Não existe um cadastro de skill para o usuário com código %d",
        userSkillId
      )
    );
  }
}
