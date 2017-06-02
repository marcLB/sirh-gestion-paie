package dev.paie.repository;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;

@ContextConfiguration(classes = { ServicesConfig.class })
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
//		Avantage nouvelAvantage = new Avantage("cod","bla",1);
//		Avantage modifAvantage = new Avantage(1,"cod","bla",1);
//		
//		//TODO sauvegarder un nouvel avantage
//		Avantage avantageSaved=this.avantageRepository.save(nouvelAvantage);
//		assertNotNull(avantageSaved);		
//		
//		
//		//TODO vérifier qu'il est possible de récupérer le nouvel avantage via la méthode findOne
//		Avantage av = this.avantageRepository.findOne(19);
//		assertNotNull(av);
//		
//		//TODO modifier un avantage
//		this.avantageRepository.save(modifAvantage);
		//TODO vérifier que les modifications sont bien prises en compte via la méthode findOne
	}
}