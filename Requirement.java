package edu.jsp.HrManagement.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Requirement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String branchDealCode;
	private String companyName;
	private String jobTitle;
	private String designation;
	private String jobLocation;
	private String skillsRequired;
	
	private String noOfVacantPositions;
	private String noOfCandidatesRequired;
	
	private LocalDate interviewDate;
	
	private String genderSpecifications;
	private String modeOfInterview;
	
	private Double tenthPercent;
	private Double twelfthPercent;
	private Double degreePercent;
	private String qualificationType;
	
	@OneToMany(mappedBy = "requirement")
	private List<RequirementStudent> requirementStudent;
	
	
	public List<RequirementStudent> getRequirementStudent() {
		return requirementStudent;
	}
	public void setRequirementStudent(List<RequirementStudent> requirementStudent) {
		this.requirementStudent = requirementStudent;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBranchDealCode() {
		return branchDealCode;
	}
	public void setBranchDealCode(String branchDealCode) {
		this.branchDealCode = branchDealCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public String getNoOfVacantPositions() {
		return noOfVacantPositions;
	}
	public void setNoOfVacantPositions(String noOfVacantPositions) {
		this.noOfVacantPositions = noOfVacantPositions;
	}
	public String getNoOfCandidatesRequired() {
		return noOfCandidatesRequired;
	}
	public void setNoOfCandidatesRequired(String noOfCandidatesRequired) {
		this.noOfCandidatesRequired = noOfCandidatesRequired;
	}
	public LocalDate getInterviewDate() {
		return interviewDate;
	}
	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}
	public String getGenderSpecifications() {
		return genderSpecifications;
	}
	public void setGenderSpecifications(String genderSpecifications) {
		this.genderSpecifications = genderSpecifications;
	}
	public String getModeOfInterview() {
		return modeOfInterview;
	}
	public void setModeOfInterview(String modeOfInterview) {
		this.modeOfInterview = modeOfInterview;
	}
	public Double getTenthPercent() {
		return tenthPercent;
	}
	public void setTenthPercent(Double tenthPercent) {
		this.tenthPercent = tenthPercent;
	}
	public Double getTwelfthPercent() {
		return twelfthPercent;
	}
	public void setTwelfthPercent(Double twelfthPercent) {
		this.twelfthPercent = twelfthPercent;
	}
	public Double getDegreePercent() {
		return degreePercent;
	}
	public void setDegreePercent(Double degreePercent) {
		this.degreePercent = degreePercent;
	}
	public String getQualificationType() {
		return qualificationType;
	}
	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
	}
	
	
}
