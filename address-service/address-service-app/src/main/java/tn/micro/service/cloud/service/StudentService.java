package tn.micro.service.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.repository.AddressRepository;
import tn.micro.service.cloud.request.CreateStudentRequest;
import tn.micro.service.cloud.response.StudentResponse;

@Service
public class StudentService implements IStudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());

		address = addressRepository.save(address);

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());

		student.setAddress(address);
		student = studentRepository.save(student);

		return new StudentResponse(student);
	}

	@Override
	public StudentResponse getById(long id) {
		return new StudentResponse(studentRepository.findById(id).get());
	}

	@Override
	public List<StudentResponse> getAllStudents() {
		return StudentResponse.toArrayList(studentRepository.findAll());
	}
}
