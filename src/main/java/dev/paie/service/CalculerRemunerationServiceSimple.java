package dev.paie.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.util.PaieUtils;

@Service
public class CalculerRemunerationServiceSimple implements CalculerRemunerationService {

	@Autowired
	private PaieUtils paieUtils;
	
	@Override
	public ResultatCalculRemuneration calculer(BulletinSalaire bulletin) {

		ResultatCalculRemuneration res = new ResultatCalculRemuneration();
		
		Grade grade = bulletin.getRemunerationEmploye().getGrade();
		BigDecimal salaireBase = grade.getNbHeuresBase().multiply(grade.getTauxBase());
		res.setSalaireDeBase(paieUtils.formaterBigDecimal(salaireBase));
		
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		res.setSalaireBrut(paieUtils.formaterBigDecimal(salaireBrut));
		
		ProfilRemuneration profil = bulletin.getRemunerationEmploye().getProfilRemuneration();
		// https://stackoverflow.com/questions/22635945/adding-up-bigdecimals-using-streams
		BigDecimal totalRetenueSalariale = profil.getCotisationsNonImposables()
												.stream()
												.filter(t -> t.getTauxSalarial() != null)
												.map(t -> t.getTauxSalarial())
												.reduce(BigDecimal.ZERO, BigDecimal::add)
												.multiply(salaireBrut);
		res.setTotalRetenueSalarial(paieUtils.formaterBigDecimal(totalRetenueSalariale));
		
		BigDecimal totalCotisationsPatronales = profil.getCotisationsNonImposables()
												.stream()
												.filter(t -> t.getTauxPatronal() != null)
												.map(t -> t.getTauxPatronal())
												.reduce(BigDecimal.ZERO, BigDecimal::add)
												.multiply(salaireBrut);
		res.setTotalCotisationsPatronales(paieUtils.formaterBigDecimal(totalCotisationsPatronales));
		
		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalariale);
		res.setNetImposable(paieUtils.formaterBigDecimal(netImposable));
		
		BigDecimal netAPayer = netImposable.subtract(profil.getCotisationsImposables()
													.stream()
													.filter(t -> t.getTauxSalarial() != null)
													.map(t -> t.getTauxSalarial())
													.reduce(BigDecimal.ZERO, BigDecimal::add)
													.multiply(salaireBrut)
												);
		res.setNetAPayer(paieUtils.formaterBigDecimal(netAPayer));
		
		return res;
	}

}
