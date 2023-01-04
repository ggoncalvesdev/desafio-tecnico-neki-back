package com.neki.api.controller;

import com.neki.domain.dto.CredentialLoginDTO;
import com.neki.domain.model.Usuario;
import com.neki.domain.service.UserService;
import com.neki.domain.service.security.JWTUtil;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserService userService;

  @Autowired
  private JWTUtil jwtUtil;

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private PasswordEncoder passwordEncoder;

  // Registro de usuario
  @PostMapping("/registro")
  public Map<String, Object> registerHandler(@RequestBody Usuario user) {
    // Encriptando a senha usando o Bcrypt
    String encodedPass = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPass);

    user = userService.saveUser(user);

    // Gerando o token JWT a partir dos dados do Usuario
    Usuario usuarioResumido = new Usuario();
    usuarioResumido.setId(user.getId());
    usuarioResumido.setLogin(user.getLogin());
    usuarioResumido.setLastLoginDate(user.getLastLoginDate());
    String token = jwtUtil.generateTokenWithUserData(usuarioResumido);

    // Retornando a resposta com o JWT
    return Collections.singletonMap("jwt-token", token);
  }

  @PostMapping("/login")
  public Map<String, Object> loginHandler(
    @RequestBody CredentialLoginDTO credentialLoginDTO
  ) {
    try {
      // Criando o token que sera usado no processo de autenticacao
      UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
        credentialLoginDTO.getLogin(),
        credentialLoginDTO.getPassword()
      );

      // Autenticando as credenciais de login
      authManager.authenticate(authInputToken);

      // Se o processo de autenticacao foi concluido com sucesso - etapa anterior,
      // eh gerado o JWT

      Usuario user = userService.findByLogin(credentialLoginDTO.getLogin());
      Usuario usuarioResumido = new Usuario();
      usuarioResumido.setId(user.getId());
      usuarioResumido.setLogin(user.getLogin());
      usuarioResumido.setLastLoginDate(user.getLastLoginDate());
      // Gerando o token JWT a partir dos dados do Usuario
      String token = jwtUtil.generateTokenWithUserData(usuarioResumido);

      // Responde com o JWT
      return Collections.singletonMap("jwt-token", token);
    } catch (AuthenticationException authExc) {
      throw new RuntimeException("Credenciais Invalidas");
    }
  }
}
