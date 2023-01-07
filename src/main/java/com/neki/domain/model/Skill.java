package com.neki.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(
  name = "generator_skill",
  sequenceName = "skill_seq",
  initialValue = 1000,
  allocationSize = 1,
  schema = "teste_residencia"
)
@Entity
@Table(name = "skill", schema = "teste_residencia")
public class Skill {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "generator_skill"
  )
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

  @ManyToMany(mappedBy = "skill")
  @JsonBackReference
  private List<Usuario> user = new ArrayList<Usuario>();
}
