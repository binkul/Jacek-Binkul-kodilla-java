package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyByThreeFirstLetter(@Param("SHORTCUT") String shortcut);

    @Query
    Optional<List<Company>> retrieveCompanyByShortcut(@Param("SHORTCUT") String shortcut);

    @Override
    void deleteAll();
}
