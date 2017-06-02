package dev.paie.service;

import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {
	@Autowired ApplicationContext context;
	@PersistenceContext  private EntityManager em;
	
	@Override
	@Transactional 
	public void initialiser() {
		Stream.of(Cotisation.class, Entreprise.class, Grade.class, ProfilRemuneration.class)
		.forEach(classe -> context.getBeansOfType(classe).forEach((nom, bean) -> em.persist(bean)));
		//this.remplirPeriode();
	}

//	private void remplirPeriode() {
//		Periode periode = new Periode();
//		int year = LocalDate.now().getYear();
//		periode.setDateDebut(dateDebut);
//	}
}

