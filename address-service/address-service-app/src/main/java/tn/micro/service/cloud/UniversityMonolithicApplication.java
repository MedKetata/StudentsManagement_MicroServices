package tn.micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.repository.AddressRepository;
import tn.micro.service.cloud.response.StudentResponse;

@SpringBootApplication
//@ComponentScan({"tn.micro.service.cloud.controller", "tn.micro.service.cloud.service"})
//@EntityScan("tn.micro.service.cloud.entity")
//@EnableJpaRepositories("tn.micro.service.cloud.repository")
public class AddressServiceApplication {

	private static StudentRepository studentRepository;
	private static AddressRepository addressRepository;

	public static void main(String[] args) {
		System.out.println("---------Démarrage----------");
        //Commencer par réaliser les injections de dépendances pour les objets de type Repository
        // référencer le contexte
        ConfigurableApplicationContext contexte = SpringApplication.run(AddressServiceApplication.class, args);
		// Récupérer une implémentation de l'interface "ProduitRepository" par injection de dépendance
        studentRepository =contexte.getBean(StudentRepository.class);
        addressRepository = contexte.getBean(AddressRepository.class);
        Address address = new Address();
		address.setStreet("Rte Mehdia Km 05");
		address.setCity("Sfax");

		address = addressRepository.save(address);

		Student student = new Student();
		student.setFirstName("Jemal");
		student.setLastName("Ahmed");
		student.setEmail("jmlhmd@gmail.com");
		student.setAddress(address);
		student = studentRepository.save(student);
		System.out.println("---------Insertion de l'étudiant "+student.getFirstName()+ " " +student.getLastName()+" et de son adresse ----------");
		Address address1 = new Address();
		address1.setStreet("Rte Menzel Chaker Km 04");
		address1.setCity("Sfax");

		address1 = addressRepository.save(address1);

		Student student1 = new Student();
		student1.setFirstName("Ben Halima");
		student1.setLastName("Riadh");
		student1.setEmail("riadh.benhalima@enis.tn");
		student1.setAddress(address1);
		student1 = studentRepository.save(student1);
		System.out.println("---------Insertion de l'étudiant "+student1.getFirstName()+ " " +student1.getLastName()+" et de son adresse ----------");
		address.setStreet("ElManzal 9");
		address.setCity("Tunis");
		student.setAddress(address);
		student = studentRepository.save(student);
		System.out.println("---------Changer l’adresse du premier étudiant ----------");
		System.out.println("---------Afficher les deux étudiants ----------");
		System.out.println(student);
		System.out.println(student1);
		studentRepository.delete(student1);
		System.out.println("---------Supprimer l’étudiant non modifié ----------");
		
	}

}
