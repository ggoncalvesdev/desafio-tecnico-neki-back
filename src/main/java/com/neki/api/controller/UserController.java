package com.neki.api.controller;

import com.neki.domain.model.Usuario;
import com.neki.domain.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public ResponseEntity<List<Usuario>> getAll() {
    List<Usuario> users = userService.getAll();
    if (!users.isEmpty()) return new ResponseEntity<>(
      users,
      HttpStatus.OK
    ); else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
  }
}
