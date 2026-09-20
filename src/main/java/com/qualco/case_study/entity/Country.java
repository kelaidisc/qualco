package com.qualco.case_study.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "countries")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

  @Id
  @Column(name = "country_id")
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "area", nullable = false, precision = 10, scale = 2)
  private BigDecimal area;

  @Column(name = "national_day")
  private LocalDate nationalDay;

  @Column(name = "country_code2", nullable = false)
  private String countryCode2;

  @Column(name = "country_code3", nullable = false)
  private String countryCode3;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "region_id", insertable = false, updatable = false)
  private Region region;

}
