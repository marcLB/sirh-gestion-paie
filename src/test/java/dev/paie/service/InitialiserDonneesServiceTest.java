package dev.paie.service;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.config.WebAppConfig;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@ContextConfiguration(classes = {  WebAppConfig.class })
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class InitialiserDonneesServiceTest implements InitialiserDonneesService{
	
	@Autowired private EntityManager em;
	@Autowired private ApplicationContext context;
	
	@Override
	@Transactional
	public void initialiser() {
		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
			.forEach(classe -> context.getBeansOfType(classe).forEach((nom, bean) -> em.persist(bean)));
	}
	
}