package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRenumerationRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired private ApplicationContext context;
	
	@Autowired private CotisationService cotisationService;
	@Autowired private EntrepriseRepository entrepriseRepo;
	@Autowired private GradeRepository gradeRepo;
	@Autowired private ProfilRenumerationRepository profilRepo;
	@Autowired private PeriodeRepository periodeRepo;
	
	@Override
	public void initialiser() {
		Map<String, Cotisation> mapCotisationsNonImposables = context.getBeansOfType(Cotisation.class);
		mapCotisationsNonImposables.forEach((k, v) -> {
			cotisationService.sauvegarder(v);
		});
		
		Map<String, ProfilRemuneration> mapProfils = context.getBeansOfType(ProfilRemuneration.class);
		mapProfils.forEach((k, v) -> {
			profilRepo.save(v);
		});
		
		Map<String, Entreprise> mapEntreprises = context.getBeansOfType(Entreprise.class);
		mapEntreprises.forEach((k, v) -> {
			entrepriseRepo.save(v);
		});
		
		Map<String, Grade> mapGrades = context.getBeansOfType(Grade.class);
		mapGrades.forEach((k, v) -> {
			gradeRepo.save(v);
		});
		
		List<Periode> listePeriodes = initPeriodes();
		listePeriodes.forEach(v -> periodeRepo.save(v));
		
	}

	private List<Periode> initPeriodes() {
		List<Periode> list = new ArrayList<>();
		
		for(int i=0 ; i<12 ; i++) {
			Periode p = new Periode();
			p.setDateDebut(LocalDate.of(2017, i+1, 1));
			p.setDateFin(list.get(i).getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
			list.add(p);
		}
		
		return list;
	}

}
