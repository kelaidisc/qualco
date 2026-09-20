package com.qualco.case_study.controller;

import com.qualco.case_study.dto.ExploreDto;
import com.qualco.case_study.dto.StatMaxDto;
import com.qualco.case_study.service.CountryStatService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class CountryStatController {

  private final CountryStatService countryStatService;

  @GetMapping("/max-ratio")
  public List<StatMaxDto> getMaxRatio() {
    return countryStatService.getMaxGdpPerPopulation();
  }

  @GetMapping("/explore")
  public Page<ExploreDto> explore(
      @RequestParam(required = false) Integer regionId,
      @RequestParam(required = false) Integer yearFrom,
      @RequestParam(required = false) Integer yearTo,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    return countryStatService.explore(regionId, yearFrom, yearTo, page, size);
  }
}
