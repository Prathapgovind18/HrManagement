package edu.jsp.HrManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.HrManagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findByContactNumber(long phone);
	
	Optional<Student> findByEmail(String email);

}
