package tn.micro.service.cloud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.micro.service.cloud.entity.Student;
import tn.micro.service.cloud.request.CreateAddressRequest;
import tn.micro.service.cloud.request.CreateStudentRequest;
import tn.micro.service.cloud.response.AddressResponse;
import tn.micro.service.cloud.response.StudentResponse;

@Service
public interface IStudentService {

	StudentResponse createStudent(CreateStudentRequest createStudentRequest);

	StudentResponse getById(long id);

	List<StudentResponse> getAllStudents();

    void deleteById(long id);

	StudentResponse updateStudent(long id, Student studentRequest);
	//AddressResponse getAddressById(long addressId);
	//AddressResponse createAddressWithWebClient(CreateAddressRequest request);

}
