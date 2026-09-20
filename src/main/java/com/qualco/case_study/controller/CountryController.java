package com.qualco.case_study.controller;

import com.qualco.case_study.dto.CountryDto;
import com.qualco.case_study.dto.RegionDto;
import com.qualco.case_study.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CountryController {

  private final CountryService countryService;

  @GetMapping("/countries")
  public List<CountryDto> getCountries() {
    return countryService.getCountries();
  }

  @GetMapping("/countries/{id}/languages")
  public List<String> getLanguages(@PathVariable Integer id) {
    return countryService.getLanguagesByCountry(id);
  }

  @GetMapping("/regions")
  public List<RegionDto> getRegions() {
    return countryService.getRegions();
  }
}
