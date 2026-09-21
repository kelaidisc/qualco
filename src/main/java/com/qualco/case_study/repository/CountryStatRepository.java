package com.qualco.case_study.repository;

import com.qualco.case_study.dto.ExploreDto;
import com.qualco.case_study.dto.StatMaxDto;
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

  @Query("""
    select new com.qualco.case_study.dto.StatMaxDto(
    cs.country.name, cs.country.countryCode3, cs.year, cs.population, cs.gdp
    ) from CountryStat cs
    where cs.population > 0
     and (cs.gdp / cs.population) = (
     select max(cs2.gdp / cs2.population)
     from CountryStat cs2
     where cs2.country = cs.country
     and cs2.population > 0
     ) order by cs.country.name
""")
  List<StatMaxDto> findCountriesMaxGdpPerPopulation();
}
