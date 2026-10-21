package edu.jsp.HrManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.HrManagement.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement, Long>{
	
	Optional<Requirement> findByBranchDealCode(String dealCode);
	
	Optional<Requirement> findByCompanyName(String name);

}
