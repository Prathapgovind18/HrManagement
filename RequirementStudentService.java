package edu.jsp.HrManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.HrManagement.entity.Requirement;
import edu.jsp.HrManagement.entity.RequirementStudent;
import edu.jsp.HrManagement.entity.Student;
import edu.jsp.HrManagement.repository.RequirementRepository;
import edu.jsp.HrManagement.repository.RequirementStudentRepository;
import edu.jsp.HrManagement.repository.StudentRepository;

@Service
public class RequirementStudentService {
	
	@Autowired
    private RequirementRepository requirementRepo;
	
	@Autowired 
	private StudentRepository studentRepo;
	
	@Autowired
	private RequirementStudentRepository requirementStudentRepo;
	
	public String mapStudent(long reqId, long stdId) {

		Requirement r = requirementRepo.findById(reqId).orElse(null);
		Student s = studentRepo.findById(stdId).orElse(null);

		if (r != null && s != null) {
			RequirementStudent rs = new RequirementStudent();
			rs.setRequirement(r);;
			rs.setStudent(s);
			requirementStudentRepo.save(rs);
			
			return "student date mapped";
		}
		return "data not found";
	}
	
	public String removeStudent(long reqId,long stdId) {
		
		Optional<RequirementStudent> o = requirementStudentRepo.fetchRequirementStrudent(reqId, stdId);
		
		if(o.isPresent()) {
			requirementStudentRepo.delete(o.get());
			return "student removed";
		}
		return "data not found";
		
	}
	
	public List<Student> fetchStudentByReq(Long reqId) {
		List<RequirementStudent> list =  requirementStudentRepo.findByRequirementId(reqId);
		
		List<Student> student = new ArrayList<>();
		
		for (RequirementStudent rs : list) {
			student.add(rs.getStudent());
		}
		return student;
	}

}
