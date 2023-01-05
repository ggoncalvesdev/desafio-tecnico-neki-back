package com.neki.domain.service.security;

import com.neki.domain.service.UsuarioDetailsServiceImpl;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private JWTFilter filter;

  @Autowired
  private UsuarioDetailsServiceImpl uds;

  //Metodo encarregado de configurar a seguranca da API
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf()
      .disable() // Desabilitando o csrf
      .httpBasic()
      .disable() // Desabilitando a autenticacao por http basico(usuario e senha)
      .cors() // Habilitando o cors
      .and()
      .authorizeHttpRequests() // Autorizando requisicoes de entrada
      /* .antMatchers(HttpMethod.DELETE, "/user/**")
      .hasAuthority("EXCLUIR_CONTA") */
      .antMatchers(
        "/auth/**",
        "/swagger-ui/**",
        "/v3/api-docs/**",
        "/actuator/**",
        "/email/**",
        "/swagger-resources/**",
        "/swagger-ui.html",
        "/v2/api-docs",
        "/webjars/**"
      )
      .permitAll() // Autorizando requisicoes autenticadas
      .antMatchers(HttpMethod.DELETE, "/user/**")
      .hasAuthority("ADMIN") // Autorizando apenas usuarios com o perfil "USER" a utilizar esse endpoint (nesse caso, path /user/ e uri´s subsequentes
      .anyRequest()
      .authenticated() // Todas as requisicoes, exceto para as definidas acima, precisarao ser autenticadas
      .and()
      .userDetailsService(uds) // Setando o servico "user details" (do modulo Security do Spring) para essa implementacao customizada
      .exceptionHandling()
      .authenticationEntryPoint((request, response, authException) -> //  Logo, isso significa que essa requisicao requer autenticacao e um JWT valido // Rejeitando requisicoes nao autorizadas que chegam ate esse ponto.
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
      )
      .and()
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Configurando a Sessao para que cada requisicao seja independente (stateless)
    /*       .and()
      .oauth2ResourceServer()
      .jwt()
      .jwtAuthenticationConverter(jwtAuthenticationConverter()); */

    // Adicionando o filtro JWT
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
