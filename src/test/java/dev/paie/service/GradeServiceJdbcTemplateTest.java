package dev.paie.service;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.util.JeuxDeDonneesConfig;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {
	
	@Autowired private GradeService gradeService;
	
	
	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		Grade nouveauGrade1 = new Grade("10",new BigDecimal("50"),new BigDecimal("10"));
		Grade nouveauGrade2 = new Grade("11",new BigDecimal("500"),new BigDecimal("100"));
		Grade gradeToModif = new Grade("10",new BigDecimal("5000"),new BigDecimal("1000"));
		
		this.gradeService.sauvegarder(nouveauGrade1);
		this.gradeService.sauvegarder(nouveauGrade2);
		
		List<Grade> liste = this.gradeService.lister();
		assertTrue(liste.stream().anyMatch(g -> g.getId()>0));
		
		this.gradeService.mettreAJour(gradeToModif);
		
		List<Grade> liste2 = this.gradeService.lister();
		assertTrue(liste.stream().anyMatch(g -> g.getId()>0));
		
	}
}
