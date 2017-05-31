package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService{
 	@Autowired private PaieUtils paieUtils; 


		private String calculerSalaireDeBase(Grade grade) {
			BigDecimal result = grade.getNbHeuresBase().multiply(grade.getTauxBase());
			return paieUtils.formaterBigDecimal(result);
		}

		public String calculerSalaireBrut(String salaireDeBase, BigDecimal primeEx) {
			BigDecimal salaireBrut = new BigDecimal(salaireDeBase);

			if (primeEx != null) {
				salaireBrut = salaireBrut.add(primeEx);
			}
			return paieUtils.formaterBigDecimal(salaireBrut);
		}

		public String calculerTotalRetenueSalarial(String salaireBrut, List<Cotisation> cotisationsNonImposables) {
			
			return paieUtils.formaterBigDecimal(
					cotisationsNonImposables.stream()
					.filter(c -> c.getTauxSalarial() != null)
					.map(c -> c.getTauxSalarial().multiply(new BigDecimal(salaireBrut)))
					.collect(Collectors.reducing((v1,v2) -> v1.add(v2)))
					.orElse(new BigDecimal("0"))
					);
		}

		public String calculerNetImposable(String salaireBrut, String retenueSalariale) {
			return paieUtils.formaterBigDecimal(
					new BigDecimal(salaireBrut).subtract(new BigDecimal(retenueSalariale))
					);
		}

		public String calculerNetAPayer(String netImposable, String salaireBrut, List<Cotisation> cotisationsImposables) {
			
			return paieUtils.formaterBigDecimal(
					new BigDecimal(netImposable)
						.subtract(
							cotisationsImposables.stream()
							.filter(c -> c.getTauxSalarial() != null)
							.map(c -> c.getTauxSalarial().multiply(new BigDecimal(salaireBrut)))
							.collect(Collectors.reducing((v1,v2) -> v1.add(v2)))
							.orElse(new BigDecimal("0"))
							)
						);
		}

		
		public String calculerTotalCotisationsPatronales(String salaireBrut, List<Cotisation> cotisationsNonImposables) {
				
			return paieUtils.formaterBigDecimal(
					cotisationsNonImposables.stream()
					.filter(c -> c.getTauxPatronal() != null)
					.map(c -> c.getTauxPatronal().multiply(new BigDecimal(salaireBrut)))
					.collect(Collectors.reducing((v1,v2) -> v1.add(v2)))
					.orElse(new BigDecimal("0"))
					);
		}

		@Override
		public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {
			
			ResultatCalculRemuneration resultat = new ResultatCalculRemuneration();

			
			String salaireDeBase = calculerSalaireDeBase(bulletin.getRemunerationEmploye().getGrade());
			String salaireBrut = calculerSalaireBrut(salaireDeBase, bulletin.getPrimeExceptionnelle());
			String totalRetenueSalariale = calculerTotalRetenueSalarial(salaireBrut, bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables());
			String totalCotisationsPatronales = calculerTotalCotisationsPatronales(salaireBrut, bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsNonImposables());
			String netImposable = calculerNetImposable(salaireBrut, totalRetenueSalariale);
			String netAPayer = calculerNetAPayer(netImposable, salaireBrut, bulletin.getRemunerationEmploye().getProfilRemuneration().getCotisationsImposables());
			
			resultat.setSalaireDeBase(salaireDeBase);
			resultat.setSalaireBrut(salaireBrut);
			resultat.setTotalRetenueSalarial(totalRetenueSalariale);
			resultat.setTotalCotisationsPatronales(totalCotisationsPatronales);
			resultat.setNetImposable(netImposable);
			resultat.setNetAPayer(netAPayer);
			
			return resultat;
		}
}
