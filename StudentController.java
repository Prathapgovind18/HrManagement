package edu.jsp.HrManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.HrManagement.entity.Student;
import edu.jsp.HrManagement.service.StudentService;

@RestController
@RequestMapping("/api/student") //This will act as an route url
public class StudentController {
	
	@Autowired
	private StudentService studentSer;
	
	//http://localhost:8080/api/student
	@PostMapping
	public Student createStudent(@RequestBody Student s) {
		return studentSer.createStudent(s);
	}
	
	//http://localhost:8080/api/student/getById/1
	@GetMapping("/getById/{id}")
	public Student getStudentById(@PathVariable long id) {
		return studentSer.getStudentById(id);
	}
	
	//http://localhost:8080/api/student/getByEmail/adam@gmail.com
	@GetMapping("/getByEmail/{email}")
	public Student getStudentByEmail(@PathVariable String email) {
		return studentSer.getStudentByEmail(email);
	}
	
	//http://localhost:8080/api/student/getByPh/987654321
	@GetMapping("/getByPh/{cno}")
	public Student getStudentByContactNumber(@PathVariable long cno) {
		return studentSer.getStudentByContactNumber(cno);
	}
	
	//http://localhost:8080/api/student
	@GetMapping
	public List<Student> getAllStudents() {
		return studentSer.getAllStudents();
	}
	
	//http://localhost:8080/api/student/deleteById/3
	@DeleteMapping("/deleteById/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentSer.deleteStudent(id);
	}
}
