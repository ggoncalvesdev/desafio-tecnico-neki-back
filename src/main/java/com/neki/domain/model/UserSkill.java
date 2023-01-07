package com.neki.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SequenceGenerator(
  name = "generator_user_skilll",
  sequenceName = "user_skill_seq",
  initialValue = 1000,
  allocationSize = 1,
  schema = "teste_residencia"
)
@Entity
@Table(name = "user_skill", schema = "teste_residencia")
public class UserSkill {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "generator_user_skilll"
  )
  private Integer id;

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id")
  private Usuario user;

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinColumn(name = "skill_id")
  private Skill skill;

  @Column(name = "knowledge_level")
  private Integer KnowledgeLevel;

  @CreationTimestamp
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @Column(name = "created_at")
  private Date CreatedAt;

  @UpdateTimestamp
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  @Column(name = "updated_at")
  private Date UpdatedAt;
}
