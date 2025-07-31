package com.codingrecipe.uigunlee.company.repository;

import com.codingrecipe.uigunlee.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
