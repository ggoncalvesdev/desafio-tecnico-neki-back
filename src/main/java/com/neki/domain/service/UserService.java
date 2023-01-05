package com.neki.domain.service;

import com.neki.domain.exception.NegocioException;
import com.neki.domain.exception.UsuarioNaoEncontradoException;
import com.neki.domain.model.Usuario;
import com.neki.domain.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  private EntityManager manager;

  @Transactional
  public List<Usuario> getAll() {
    return userRepository.findAll();
  }

  @Transactional
  public Usuario findByLogin(String login) {
    return userRepository.findByLogin(login).get();
  }

  public Usuario saveUser(Usuario user) {
    detach(user);

    Optional<Usuario> usuarioExistente = userRepository.findByLogin(
      user.getLogin()
    );

    if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(user)) {
      throw new NegocioException(
        String.format(
          "Já existe um usuário cadastrado com o login %s",
          user.getLogin()
        )
      );
    }

    return userRepository.save(user);
  }

  @Transactional
  public Boolean deleteUser(Integer id) {
    Usuario user = userRepository.findById(id).orElse(null);
    if (user != null) {
      userRepository.delete(user);
      return true;
    } else {
      return false;
    }
  }

  public void detach(Usuario user) {
    manager.detach(user);
  }

  public Usuario buscarOuFalhar(Integer userId) {
    return userRepository
      .findById(userId)
      .orElseThrow(() -> new UsuarioNaoEncontradoException(userId));
  }
}
