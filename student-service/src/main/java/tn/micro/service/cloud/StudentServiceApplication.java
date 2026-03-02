package tn.micro.service.cloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import tn.micro.service.cloud.entity.Student;
import tn.micro.service.cloud.repository.StudentRepository;


@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan({"tn.micro.service.cloud.controller", "tn.micro.service.cloud.service"})
//@EntityScan("tn.micro.service.cloud.entity")
//@EnableJpaRepositories("tn.micro.service.cloud.repository")
@EnableFeignClients("tn.proxy")
public class StudentServiceApplication {
	//@Value("${address.service.url}")
	//private String addressServiceUrl;


//@Bean
//public WebClient webClient() {
//	return WebClient.builder()
//			.baseUrl(addressServiceUrl) // Définit l'URL de base
//			.build(); // Construit l'instance de WebClient
//}



	private static StudentRepository studentRepository;
	

	public static void main(String[] args) {
		System.out.println("---------Démarrage----------");
        //Commencer par réaliser les injections de dépendances pour les objets de type Repository
        // référencer le contexte
        ConfigurableApplicationContext contexte = SpringApplication.run(StudentServiceApplication.class, args);
		// Récupérer une implémentation de l'interface "ProduitRepository" par injection de dépendance
        studentRepository =contexte.getBean(StudentRepository.class);
       
		Student student = new Student();
		student.setFirstName("Pierre");
		student.setLastName("Dubois");
		student.setEmail("pierre.dubois@gmail.com");
		
		//student = studentRepository.save(student);
		System.out.println("---------Insertion de l'étudiant "+student.getFirstName()+ " " +student.getLastName()+" et de son adresse ----------");
		
		Student student1 = new Student();
		student1.setFirstName("Camille");
		student1.setLastName("Moreau");
		student1.setEmail("camille.moreau@univ-lyon.fr");
		student1 = studentRepository.save(student1);
		System.out.println("---------Insertion de l'étudiant "+student1.getFirstName()+ " " +student1.getLastName()+" et de son adresse ----------");
		
		//student = studentRepository.save(student);
		System.out.println("---------Changer l’adresse du premier étudiant ----------");
		System.out.println("---------Afficher les deux étudiants ----------");
		System.out.println(student);
		System.out.println(student1);
		studentRepository.delete(student1);
		System.out.println("---------Supprimer l’étudiant non modifié ----------");
		
	}

}
