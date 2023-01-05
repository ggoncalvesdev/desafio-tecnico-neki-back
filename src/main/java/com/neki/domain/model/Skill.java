package com.neki.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "skill", schema = "teste_residencia")
public class Skill {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;

  @Column
  @Size(max = 100)
  private String name;

  @Column
  @Size(max = 10)
  private String version;

  @Column
  private String description;

  @Column
  private String imageUrl;
}
