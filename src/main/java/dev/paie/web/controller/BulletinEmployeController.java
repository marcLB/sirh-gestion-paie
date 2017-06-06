package dev.paie.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.BulletinEmployeRepository;
import dev.paie.repository.PeriodeEmployeRepository;

@Controller
@RequestMapping("/bulletin")
public class BulletinEmployeController {
	@Autowired BulletinEmployeRepository bulletinRepo;
	@Autowired PeriodeEmployeRepository periodeRepo;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		List <Periode> listePeriode = periodeRepo.findAll();
		List <BulletinSalaire> listeBulletin= bulletinRepo.findAll();
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletin/creerBulletin");
		mv.addObject("listeBulletin",listeBulletin);
		mv.addObject("listePeriode",listePeriode);
		return mv;
	}
	
	@RequestMapping(value="/creer",method=RequestMethod.POST)
	public String form (
			@RequestParam("remunerationEmploye") RemunerationEmploye remunerationEmploye,
			@RequestParam("grade") Periode periode,
			@RequestParam("primeExceptionnelle") BigDecimal primeExceptionnelle,
			Model model) {
		BulletinSalaire re = new BulletinSalaire(
				remunerationEmploye,
				periode,
				primeExceptionnelle);
		
		bulletinRepo.saveAndFlush(re);
		model.addAttribute("StatusMessageKey","person.form.msg.sucess");
		
		return "redirect:/mvc/bulletin/lister";
	}
	
}
