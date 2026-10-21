package edu.jsp.HrManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.HrManagement.entity.Requirement;
import edu.jsp.HrManagement.repository.RequirementRepository;

@Service
public class RequirementService {
	
	@Autowired
	public RequirementRepository requirementRepo;
	
	public Requirement createRequirement(Requirement requirement) {
		return requirementRepo.save(requirement);
	}
	
	public Requirement fetchById(Long id) {
		return requirementRepo.findById(id).orElse(null);
	}
	
	public Requirement fetchByBranchDealCode(String dealCode) {
		return requirementRepo.findByBranchDealCode(dealCode).orElse(null);
	}
	
	public Requirement fetchByCompanyName(String name) {
		return requirementRepo.findByCompanyName(name).orElse(null);
	}
	
	public List<Requirement> fetchAllRequirements() {
		return requirementRepo.findAll();
	}
	
	public String deleteRequirement(Long id) {
		Optional<Requirement> o = requirementRepo.findById(id);
		if(o.isPresent())
		{
			requirementRepo.deleteById(id);
			return "Requirement Deleted";
		}
		return "Requirement Not Found";
	}
	
	public String updateRequirement(Long id,Requirement newReq) {
		Optional<Requirement> o = requirementRepo.findById(id);
		if(o.isPresent())
		{
			Requirement oldReq = o.get();
			oldReq.setId(newReq.getId());
			oldReq.setBranchDealCode(newReq.getBranchDealCode());
			oldReq.setCompanyName(newReq.getCompanyName());
			oldReq.setJobTitle(newReq.getJobTitle());
			oldReq.setDesignation(newReq.getDesignation());
			oldReq.setJobLocation(newReq.getJobLocation());
			oldReq.setSkillsRequired(newReq.getSkillsRequired());
			oldReq.setNoOfVacantPositions(newReq.getNoOfVacantPositions());
			oldReq.setNoOfCandidatesRequired(newReq.getNoOfCandidatesRequired());
			oldReq.setInterviewDate(newReq.getInterviewDate());
			oldReq.setGenderSpecifications(newReq.getGenderSpecifications());
			oldReq.setModeOfInterview(newReq.getModeOfInterview());
			oldReq.setTenthPercent(newReq.getTenthPercent());
			oldReq.setTwelfthPercent(newReq.getTwelfthPercent());
			oldReq.setDegreePercent(newReq.getDegreePercent());
			oldReq.setQualificationType(newReq.getQualificationType());
			requirementRepo.save(oldReq);
			return "Requirement Data Updated";
		}
		return "Requirement Not Found";
	}
}
