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
import dev.paie.entite.Cotisation;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	@Autowired private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
//		Cotisation nouvelleCotisation = new Cotisation("100", "1000", new BigDecimal("50"),new BigDecimal("10"));
//		
//		this.cotisationService.sauvegarder(nouvelleCotisation);
		//TODO sauvegarder une nouvelle cotisation
		
		//TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la méthode lister
		//TODO modifier une cotisation
		//TODO vérifier que les modifications sont bien prises en compte via la méthode lister
	}
}