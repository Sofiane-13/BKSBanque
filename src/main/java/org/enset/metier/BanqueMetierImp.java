package org.enset.metier;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Date;

import org.enset.dao.CompteRepository;
import org.enset.dao.OperationRepository;
import org.enset.esntities.Compte;
import org.enset.esntities.CompteCourant;
import org.enset.esntities.Operation;
import org.enset.esntities.Retrait;
import org.enset.esntities.Versement;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class BanqueMetierImp implements IBanqueMetier{
	@Autowired
private CompteRepository compteRepository;
	@Autowired
private OperationRepository operationRepository;
	@Override
	public Compte consulterCompte(String CodeCpte) {
 Compte cp=compteRepository.findOne(CodeCpte);
 if(cp==null) throw new RuntimeException("Le compte n'existe pas");
		return cp;
	}

	@Override
	public void verser(String CodeCpte, double montant) {
		if(montant<0)throw new RuntimeException("Le montant doit etre positive.");
		Compte cp=consulterCompte(CodeCpte);
		Versement v=new Versement(new Date(), montant, cp);
		operationRepository.save(v);
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
		
	}

	@Override
	public void retirer(String CodeCpte, double montant) {
		if(montant<0)throw new RuntimeException("Le montant doit etre positive.");
		Compte cp=consulterCompte(CodeCpte);
		double facilitescaisse=0;
		if(cp instanceof CompteCourant)  facilitescaisse=((CompteCourant) cp).getDecouvert();
		if(cp.getSolde()+facilitescaisse<montant) throw new RuntimeException("Impossible de retirer cette somme");
Retrait R=new Retrait(new Date(), montant, cp);
		operationRepository.save(R);
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
		
	}

	@Override
	public void virement(String CodeCpte1, String CodeCpte2, double montant) {
		if(CodeCpte1.equals(CodeCpte2))throw new RuntimeException("On peut pas effectuer un virement sur le meme compte.");
		if(montant<0)throw new RuntimeException("Le montant doit etre positive.");
		retirer(CodeCpte1, montant);
		verser(CodeCpte2, montant);
		
	}

	@Override
	public Page<Operation> listeoperation(String CodeCpte, int page, int size) {
		// TODO Auto-generated method stub
		return operationRepository.listOpperations(CodeCpte, new PageRequest(page, size));
	//return null;
	}

}
