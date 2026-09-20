package com.qualco.case_study.repository;

import com.qualco.case_study.entity.Region;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
  List<Region> findAllByOrderByNameAsc();
}
