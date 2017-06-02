package dev.paie.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.ProfilRepository;


@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	@Autowired EntrepriseRepository entrepriseRepo;
	@Autowired ProfilRepository profilRepo;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		List <Entreprise> listeEntreprise = entrepriseRepo.findAll();
		List <ProfilRemuneration> listeProfil = profilRepo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("listeEntreprises",listeEntreprise);
		mv.addObject("listeProfil",listeProfil);
		return mv;
	}
}
