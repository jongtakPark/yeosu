package com.exposition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exposition.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Company findByMid(String mid);
	boolean existsByMid(String mid);
	Company save(Company company);
	

}
