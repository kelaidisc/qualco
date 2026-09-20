package com.qualco.case_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "country_stats")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryStat {

  @EmbeddedId
  private CountryStatId id;

  @Column(name = "year", nullable = false)
  private Integer year;

  @Column(name = "population", nullable = false)
  private Integer population;

  @Column(name = "gdp", nullable = false, precision = 15)
  private BigDecimal gdp;

  @MapsId
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "country_id", insertable = false, updatable = false)
  private Country country;
}
