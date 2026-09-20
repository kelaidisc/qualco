package com.qualco.case_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "country_languages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguage {

  @EmbeddedId
  private CountryLanguageId id;

  @Column(name = "official")
  @Builder.Default
  private boolean official = false;
}
