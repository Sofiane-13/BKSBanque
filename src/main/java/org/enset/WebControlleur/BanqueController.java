package org.enset.WebControlleur;


import org.enset.esntities.Compte;
import org.enset.esntities.Operation;
import org.enset.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BanqueController {
	@Autowired
private IBanqueMetier banqueMetier;
	@RequestMapping("/operation")
	public String index(){
		return "compte";
	}
	
	@RequestMapping("/consultercompte")
	public String consulter(Model model,String codeCompte,@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5") int size){
		model.addAttribute("codeCompte", codeCompte);
		try {
			Compte cp=banqueMetier.consulterCompte(codeCompte);
			Page<Operation> pageOperation=banqueMetier.listeoperation(codeCompte, page, size);
			model.addAttribute("listOperation", pageOperation.getContent());
			int[] pages=new int[pageOperation.getTotalPages()];
			model.addAttribute("pages", pages);
			  model.addAttribute("compte", cp);
		} catch (Exception e) {
			
			model.addAttribute("exception", e);
			
		}
		
		return "compte";
	}
	
	@RequestMapping(value="/saveOperation", method=RequestMethod.POST)
	public String saveOperation(Model model,String typeOperation,String codeCompte,double montant,String codeCompte2){
		
		try {
			if(typeOperation.equals("VERS")){
				banqueMetier.verser(codeCompte, montant);
			}
			else if(typeOperation.equals("RETR")){
				banqueMetier.retirer(codeCompte, montant);
			}
			else if(typeOperation.equals("VIRE")){
				banqueMetier.virement(codeCompte, codeCompte2, montant);
			}
		} catch (Exception e) {
			model.addAttribute("exception", e);
			return "redirect:/consultercompte?codeCompte="+codeCompte+"&error="+e.getMessage();
			}
		
		return "redirect:/consultercompte?codeCompte="+codeCompte;
	}
}
