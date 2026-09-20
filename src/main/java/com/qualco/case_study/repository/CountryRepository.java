package com.qualco.case_study.repository;

import com.qualco.case_study.entity.Country;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
  List<Country> findAllByOrderByNameAsc();
}
