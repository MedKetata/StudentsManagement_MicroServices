package tn.micro.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import tn.micro.service.cloud.entity.Address;
import tn.micro.service.cloud.repository.AddressRepository;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan({"tn.micro.service.cloud.controller", "tn.micro.service.cloud.service"})
//@EntityScan("tn.micro.service.cloud.entity")
//@EnableJpaRepositories("tn.micro.service.cloud.repository")
public class AddressServiceApplication {

	private static AddressRepository addressRepository;

	public static void main(String[] args) {
		System.out.println("---------Démarrage----------");
        //Commencer par réaliser les injections de dépendances pour les objets de type Repository
        // référencer le contexte
        ConfigurableApplicationContext contexte = SpringApplication.run(AddressServiceApplication.class, args);
		// Récupérer une implémentation de l'interface "ProduitRepository" par injection de dépendance
        addressRepository = contexte.getBean(AddressRepository.class);

        Address address = new Address();
		address.setStreet("15 Rue de la République");
		address.setCity("Lyon");
		address = addressRepository.save(address);

		Address address1 = new Address();
		address1.setStreet("8 Avenue des Champs-Élysées");
		address1.setCity("Paris");
		address1 = addressRepository.save(address1);
		System.out.println(address);
		System.out.println(address1);


		
	}

}
