package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import java.util.stream.IntStream;
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
		this.remplirPeriode();
	}

	private void remplirPeriode() {
		LocalDate aujourdhui= LocalDate.now();
		IntStream.range(1,13).forEach(mois -> {
			Periode periode = new Periode();
			periode.setDateDebut(LocalDate.of(aujourdhui.getYear(), mois, 1));
			periode.setDateFin(periode.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
			em.persist(periode);
		});
	}
}