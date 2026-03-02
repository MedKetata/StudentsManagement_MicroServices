package tn.micro.service.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.micro.service.cloud.entity.Student;
import tn.micro.service.cloud.request.CreateStudentRequest;
import tn.micro.service.cloud.response.StudentResponse;
import tn.micro.service.cloud.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}
	
	@GetMapping("/getById/{id}")
	public StudentResponse getById (@PathVariable long id) {
		return studentService.getById(id);
	}
	@GetMapping("/getAllStudent")
	public List<StudentResponse> getAll (){
		return studentService.getAllStudents();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteById (@PathVariable long id) {
		 studentService.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public StudentResponse updateStudent(
			@PathVariable long id,
			@RequestBody Student studentRequest) {

		return studentService.updateStudent(id, studentRequest);
	}
}

