package com.qualco.case_study.repository;

import com.qualco.case_study.dto.ExploreDto;
import com.qualco.case_study.entity.CountryStat;
import com.qualco.case_study.entity.CountryStatId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryStatRepository extends JpaRepository<CountryStat, CountryStatId> {

  @Query("""
      SELECT new com.qualco.case_study.dto.ExploreDto(
      cs.country.region.continent.name,
      cs.country.region.name,
      cs.country.region.id,
      cs.country.name,
      cs.year,
      cs.population,
      cs.gdp
      ) FROM CountryStat cs
    """)
  List<ExploreDto> findAllForExplore();

  @Query("SELECT cs from CountryStat cs JOIN FETCH cs.country where cs.population > 0 and cs.gdp > 0")
  List<CountryStat> findAllWithCountryPopulationAndGdp();
}
