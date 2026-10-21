package edu.jsp.HrManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.jsp.HrManagement.entity.RequirementStudent;

public interface RequirementStudentRepository extends JpaRepository<RequirementStudent, Long> {
	
	@Query(value = "select rs from RequirementStudent re" + "where rs.requirement.id= ?1 and rs.student.id=?2")
	Optional<RequirementStudent> fetchRequirementStrudent(Long reqid,Long stdid);
	
	List<RequirementStudent> findByRequirementId(Long id);






}
