package com.qualco.case_study.service;

import com.qualco.case_study.dto.ExploreDto;
import com.qualco.case_study.dto.StatMaxDto;
import com.qualco.case_study.repository.CountryStatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryStatService {

  private final CountryStatRepository repository;

  @Transactional(readOnly = true)
  public List<StatMaxDto> getMaxGdpPerPopulation() {
    return repository.findCountriesMaxGdpPerPopulation();
  }

  @Transactional(readOnly = true)
  public Page<ExploreDto> explore(Integer regionId, Integer yearFrom, Integer yearTo, int page, int size) {
  var all = repository.findAllForExplore();
  var filtered = all.stream()
      .filter(r -> regionId == null || r.getRegionId().equals(regionId))
      .filter(r -> yearFrom == null || r.getYear() >= yearFrom)
      .filter(r -> yearTo == null || r.getYear() <= yearTo)
      .toList();

  int from = page * size;
  int to = Math.min(from + size, filtered.size());
  List<ExploreDto> pageContent = (from >= filtered.size() ? List.of() : filtered.subList(from, to));

  return new PageImpl<>(pageContent, PageRequest.of(page, size), filtered.size());
  }
}
