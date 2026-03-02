package tn.micro.service.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.micro.service.cloud.entity.Student;
import tn.micro.service.cloud.repository.StudentRepository;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.request.CreateStudentRequest;
import tn.micro.service.cloud.response.AddressResponse;
import tn.micro.service.cloud.response.StudentResponse;
import tn.micro.service.exception.AddressNotFoundException;
import tn.proxy.AddressFeignClient;

@Service
public class StudentService implements IStudentService {
	//@Autowired
	//WebClient webClient;
	@Autowired
	AddressFeignClient client;

	@Autowired
	StudentRepository studentRepository;


	@Override
	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		CreateAddressRequest request = new CreateAddressRequest();
		request.setStreet(createStudentRequest.getStreet());
		request.setCity(createStudentRequest.getCity());
		AddressResponse response = client.createStudent(request);

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(response.getId());
		student = studentRepository.save(student);

		return new StudentResponse(student, response);
	}

//
@Override
public StudentResponse getById(long id) {
	Student student = studentRepository.findById(id).orElseThrow(
			() -> new AddressNotFoundException("Étudiant non trouvé avec l'ID : " + id));
	AddressResponse response = client.getById(student.getAddressId());
	if (response == null) {
		throw new AddressNotFoundException("Adresse non trouvée pour l'ID : " + student.getAddressId());
	}
	return new StudentResponse(student, response);
}


	@Override
	public List<StudentResponse> getAllStudents() {
		return StudentResponse.toArrayList(studentRepository.findAll(),client);
	}

	@Override
	public void deleteById(long id) {
		studentRepository.deleteById(id);
	}


	@Override
	public StudentResponse updateStudent(long id, Student studentRequest) {

		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found"));

		student.setFirstName(studentRequest.getFirstName());
		student.setLastName(studentRequest.getLastName());
		student.setEmail(studentRequest.getEmail());
		student.setAddressId(studentRequest.getAddressId());

		student = studentRepository.save(student);

		AddressResponse addressResponse = client.getById(student.getAddressId());

		return new StudentResponse(student, addressResponse);
	}
//@Override
//public AddressResponse getAddressById(long addressId) {
//	try {
//		Mono<AddressResponse> addressResponseMono = webClient.get()
//				.uri("/getById/{id}", addressId)
//				.retrieve()
//				.bodyToMono(AddressResponse.class);
//		return addressResponseMono.block();
//	} catch (Exception e) {
//		e.printStackTrace();
//		return null;
//	}
//}


//	@Override
//	public AddressResponse createAddressWithWebClient(CreateAddressRequest request) {
//
//		return webClient.post()
//				.uri("/create")
//				.contentType(MediaType.APPLICATION_JSON)
//				.bodyValue(request)
//				.retrieve()
//				.bodyToMono(AddressResponse.class)
//				.block();
//	}


}