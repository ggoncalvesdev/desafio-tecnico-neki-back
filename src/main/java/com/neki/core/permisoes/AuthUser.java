package com.neki.core.permisoes;

import java.util.Collection;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class AuthUser implements UserDetails {

  private static final long serialVersionUID = 1L;

  private Integer id;
  private String login;
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  public AuthUser() {}

  public AuthUser(Integer id, String login, String password) {
    super();
    this.id = id;
    this.login = login;
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
