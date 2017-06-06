package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRepository;
import dev.paie.repository.RemunerationEmployeRepository;


@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	@Autowired EntrepriseRepository entrepriseRepo;
	@Autowired ProfilRepository profilRepo;
	@Autowired GradeRepository gradeRepo;
	@Autowired RemunerationEmployeRepository remunEmplRepo;
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		List <Entreprise> listeEntreprise = entrepriseRepo.findAll();
		List <ProfilRemuneration> listeProfil = profilRepo.findAll();
		List <Grade> listeGrade = gradeRepo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		mv.addObject("listeEntreprises",listeEntreprise);
		mv.addObject("listeProfil",listeProfil);
		mv.addObject("listeGrade",listeGrade);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerEmploye() {
		List<RemunerationEmploye> listeRemunerationEmploye= remunEmplRepo.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/listerEmploye");
		mv.addObject("listeEmpl",listeRemunerationEmploye);
		return mv;
	}
	
	@RequestMapping(value="/creer",method=RequestMethod.POST)
	public String form (
			@RequestParam("matricule") String matricule,
			@RequestParam("grade") Integer gradeId,
			@RequestParam("entreprise") Integer entrepriseId,
			@RequestParam("profil") Integer profilId,
			Model model) {
		RemunerationEmploye re = new RemunerationEmploye(
				matricule,
				entrepriseRepo.findOne(entrepriseId),
				profilRepo.findOne(profilId),
				gradeRepo.findOne(gradeId));
		
		remunEmplRepo.saveAndFlush(re);
		model.addAttribute("StatusMessageKey","person.form.msg.sucess");
		
		return "redirect:/mvc/employes/lister";
	}
	
}
