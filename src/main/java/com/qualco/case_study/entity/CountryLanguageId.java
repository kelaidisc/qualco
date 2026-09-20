package com.qualco.case_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Embeddable
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CountryLanguageId implements Serializable {

  @Column(name = "country_id", nullable = false, updatable = false)
  private Integer countryId;

  @Column(name = "language_id", nullable = false, updatable = false)
  private Integer languageId;
}
