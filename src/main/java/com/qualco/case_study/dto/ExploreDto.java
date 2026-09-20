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
public class ExploreDto {

  private String continentName;
  private String regionName;
  private Integer regionId;
  private String countryName;
  private Integer year;
  private Integer population;
  private BigDecimal gdp;
}
