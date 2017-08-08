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
		String salaireBaseString = paieUtils.formaterBigDecimal(salaireBase);
		res.setSalaireDeBase(salaireBaseString);
		salaireBase = new BigDecimal(salaireBaseString);
		
		BigDecimal salaireBrut = salaireBase.add(bulletin.getPrimeExceptionnelle());
		String salaireBrutString = paieUtils.formaterBigDecimal(salaireBrut);
		res.setSalaireBrut(salaireBrutString);
		salaireBrut = new BigDecimal(salaireBrutString);
		
		ProfilRemuneration profil = bulletin.getRemunerationEmploye().getProfilRemuneration();
		// https://stackoverflow.com/questions/22635945/adding-up-bigdecimals-using-streams
		BigDecimal totalRetenueSalariale = profil.getCotisationsNonImposables()
												.stream()
												.filter(t -> t.getTauxSalarial() != null)
												.map(t -> t.getTauxSalarial())
												.reduce(BigDecimal.ZERO, BigDecimal::add)
												.multiply(salaireBrut);
		String totalRetenueSalarialeString = paieUtils.formaterBigDecimal(totalRetenueSalariale);
		totalRetenueSalariale = new BigDecimal(totalRetenueSalarialeString);
		res.setTotalRetenueSalarial(totalRetenueSalarialeString);
		
		BigDecimal totalCotisationsPatronales = profil.getCotisationsNonImposables()
												.stream()
												.filter(t -> t.getTauxPatronal() != null)
												.map(t -> t.getTauxPatronal())
												.reduce(BigDecimal.ZERO, BigDecimal::add)
												.multiply(salaireBrut);
		String totalCotisationsPatronalesString = paieUtils.formaterBigDecimal(totalCotisationsPatronales);
		totalCotisationsPatronales = new BigDecimal(totalCotisationsPatronalesString);
		res.setTotalCotisationsPatronales(totalCotisationsPatronalesString);
		
		BigDecimal netImposable = salaireBrut.subtract(totalRetenueSalariale);
		String netImposableString = paieUtils.formaterBigDecimal(netImposable);
		netImposable = new BigDecimal(netImposableString);
		res.setNetImposable(netImposableString);
		
		BigDecimal netAPayer = netImposable.subtract(profil.getCotisationsImposables()
													.stream()
													.filter(t -> t.getTauxSalarial() != null)
													.map(t -> t.getTauxSalarial())
													.reduce(BigDecimal.ZERO, BigDecimal::add)
													.multiply(salaireBrut)
												);
		String netAPayerString = paieUtils.formaterBigDecimal(netAPayer);
		netAPayer = new BigDecimal(netAPayerString);
		res.setNetAPayer(netAPayerString);
		
		return res;
	}

}
