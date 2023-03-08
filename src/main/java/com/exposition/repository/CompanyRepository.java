package com.exposition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exposition.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	
	Company findByCom(String string);
	boolean existsByCom(String com);
<<<<<<< HEAD
	Company findByEmail(String email);

=======
	
>>>>>>> e08d36987abe61f464984a8bb3ed7d3691a5f01c
	

}
