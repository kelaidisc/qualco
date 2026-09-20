package com.qualco.case_study.service;

import com.qualco.case_study.dto.CountryDto;
import com.qualco.case_study.dto.RegionDto;
import com.qualco.case_study.repository.CountryRepository;
import com.qualco.case_study.repository.LanguageRepository;
import com.qualco.case_study.repository.RegionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryService {
  private final CountryRepository countryRepository;
  private final LanguageRepository languageRepository;
  private final RegionRepository regionRepository;

  @Transactional(readOnly = true)
  public List<CountryDto> getCountries() {
    return countryRepository.findAllByOrderByNameAsc()
        .stream()
        .map(c -> new CountryDto(c.getId(), c.getName(), c.getArea(), c.getCountryCode2()))
        .toList();
  }

  @Transactional(readOnly = true)
  public List<String> getLanguagesByCountry(Integer countryId) {
    return languageRepository.findLanguagesByCountryId(countryId);
  }

  @Transactional(readOnly = true)
  public List<RegionDto> getRegions() {
    return regionRepository.findAllByOrderByNameAsc()
        .stream()
        .map(r -> new RegionDto(r.getId(), r.getName()))
        .toList();
  }
}
