package com.neki.domain.service;

import com.neki.core.permisoes.AuthUser;
import com.neki.domain.model.Usuario;
import com.neki.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UsuarioDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  /**
   * Função para coletar os dados do usuário logado
   */
  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(String userLogin)
    throws UsernameNotFoundException {
    Usuario user = userRepository
      .findByLogin(userLogin)
      .orElseThrow(() ->
        new UsernameNotFoundException(
          "Usuário não encontrado com o login informado"
        )
      );

    return new AuthUser(user.getId(), user.getLogin(), user.getPassword());
  }
}
