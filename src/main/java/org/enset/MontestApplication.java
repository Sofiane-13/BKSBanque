package org.enset;

import java.util.Date;

import org.enset.dao.ClientRepository;
import org.enset.dao.CompteRepository;
import org.enset.dao.OperationRepository;
import org.enset.esntities.Client;
import org.enset.esntities.Compte;
import org.enset.esntities.CompteCourant;
import org.enset.esntities.Operation;
import org.enset.esntities.Retrait;
import org.enset.esntities.Versement;
import org.enset.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MontestApplication implements CommandLineRunner{
	@Autowired
private ClientRepository clientRepository;
	@Autowired
private CompteRepository compteRepository;
	@Autowired
private OperationRepository operationRepository;
	@Autowired
private IBanqueMetier banqueMetier;
	public static void main(String[] args) {
		SpringApplication.run(MontestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {

		/*Client c1=clientRepository.save(new Client("Belhad kacem", "sofiane@outlook.fr"));
		Client c2=clientRepository.save(new Client("Dali youcef", "hadi@outlook.fr"));
		
		Compte cp1=compteRepository.save(new CompteCourant("cp1", new Date(), 30000.0, c1, 1000.0));
		Compte cp2=compteRepository.save(new CompteCourant("cp2", new Date(), 60000.0, c2, 1000.0));
		
		Operation op1=operationRepository.save(new Versement(new Date(), 30000.0, cp1));
		Operation op2=operationRepository.save(new Versement(new Date(), 30000.0, cp2));
		
		Operation op3=operationRepository.save(new Retrait(new Date(), 10000.0, cp1));
		Operation op4=operationRepository.save(new Retrait(new Date(), 20000.0, cp2));
		
		banqueMetier.verser("cp1", 11111.0);*/
	}
}
