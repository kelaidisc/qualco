package com.qualco.case_study.repository;

import com.qualco.case_study.entity.Language;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

  @Query(value = """
            SELECT l.language
            FROM languages l
            JOIN country_languages cl ON l.language_id = cl.language_id
            WHERE cl.country_id = :countryId
            ORDER BY l.language
            """, nativeQuery = true)
  List<String> findLanguagesByCountryId(@Param("countryId") Integer countryId);
}
