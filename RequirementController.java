package edu.jsp.HrManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.HrManagement.entity.Requirement;
import edu.jsp.HrManagement.entity.RequirementStudent;
import edu.jsp.HrManagement.entity.Student;
import edu.jsp.HrManagement.service.RequirementService;
import edu.jsp.HrManagement.service.RequirementStudentService;

@RestController
@RequestMapping("api/Requirement")
public class RequirementController {
	
	//Compulsary we need data - go for @PathVariable
	//Optional arguements - go for @RequestParam
	
	@Autowired
	public RequirementService requirementSer;
	
	@Autowired
	public RequirementStudentService requirementStudentSer;

	//http://localhost:8080/api/Requirement
	@PostMapping()
	public Requirement createRequirement(@RequestBody Requirement requirement) {
		return requirementSer.createRequirement(requirement);
	}
	
	//http://localhost:8080/api/Requirement/1
	@GetMapping("{id}")
	public Requirement fetchById(@PathVariable Long id) {
		return requirementSer.fetchById(id);
	}
	
	//http://localhost:8080/api/Requirement/branch/QSP1234
	@GetMapping("branch/{dealCode}")
	public Requirement fetchByBranchDealCode(@PathVariable String dealCode) {
		return requirementSer.fetchByBranchDealCode(dealCode);
	}
	
	//http://localhost:8080/api/Requirement/company/Qspiders Technologies Pvt Ltd
	@GetMapping("/company/{name}")
	public Requirement fetchByCompanyName(@PathVariable String name) {
		return requirementSer.fetchByCompanyName(name);
	}
	
	//http://localhost:8080/api/Requirement
	@GetMapping()
	public List<Requirement> fetchAllRequirements() {
		return requirementSer.fetchAllRequirements();
	}
	
	//http://localhost:8080/api/Requirement/update/2
	@PutMapping("update/{id}")
	public String updateRequirement(@PathVariable Long id,@RequestBody Requirement newReq) {
		return requirementSer.updateRequirement(id, newReq);
	}
	
	//http://localhost:8080/api/Requirement/2
	@DeleteMapping("{id}")
	public String deleteRequirement(@PathVariable Long id) {
		return requirementSer.deleteRequirement(id);
	}
	
	@PostMapping("/mapsid")
	public String mapStudent(@RequestParam long rid, @RequestParam long sid) {
		return requirementStudentSer.mapStudent(rid,sid);
	}
	
	@DeleteMapping("/removestd")
	public String removeStudent(@RequestParam long reqId,@RequestParam long stdId) {
		return requirementStudentSer.removeStudent(reqId, stdId);
	}
	
	@GetMapping ("/getStudent/{reqId}")
	public List<Student> fetchStudentByReq(@PathVariable Long reqId) {
		return requirementStudentSer.fetchStudentByReq(reqId);
	}
	
}
