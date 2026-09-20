package com.qualco.case_study.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StatMaxDto {

  private String name;
  private String countryCode3;
  private Integer year;
  private Integer population;
  private BigDecimal gdp;
}
