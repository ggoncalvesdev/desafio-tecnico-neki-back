package com.neki.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(
  name = "generator_user",
  sequenceName = "user_seq",
  initialValue = 1000,
  allocationSize = 1,
  schema = "teste_residencia"
)
@Entity
@Table(name = "user", schema = "teste_residencia")
public class Usuario {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "generator_user"
  )
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

  @ManyToMany
  @JoinTable(
    name = "userSkill",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "skill_id")
  )
  private List<Skill> skill = new ArrayList<Skill>();
}
