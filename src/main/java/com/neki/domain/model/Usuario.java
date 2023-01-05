package com.neki.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "user", schema = "teste_residencia")
public class Usuario {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column
  @Size(max = 12)
  private String login;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @Size(max = 100)
  @Column
  private String password;

  @UpdateTimestamp
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @Column(name = "last_login_date")
  private Date lastLoginDate;
}
