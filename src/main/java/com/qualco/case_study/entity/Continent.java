package com.qualco.case_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "continents")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Continent {

  @Id
  @Column(name = "continent_id")
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;
}