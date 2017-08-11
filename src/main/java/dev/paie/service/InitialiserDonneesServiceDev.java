package dev.paie.service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.UtilisateurRepository;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired private PasswordEncoder passwordEncoder;
	
	@Autowired private ApplicationContext context;
	
	@Autowired private CotisationService cotisationService;
	@Autowired private EntrepriseRepository entrepriseRepo;
	@Autowired private GradeRepository gradeRepo;
	@Autowired private ProfilRemunerationRepository profilRepo;
	@Autowired private PeriodeRepository periodeRepo;
	@Autowired private UtilisateurRepository utilisateurRepo;
	
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
		
		List<Utilisateur> listeUtilisateurs = initUtilisateurs();
		listeUtilisateurs.forEach(v -> utilisateurRepo.save(v));
		
	}

	private List<Utilisateur> initUtilisateurs() {
		List<Utilisateur> list = new ArrayList<>();
		
		for(int i=0 ; i<3 ; i++) {
			list.add(new Utilisateur("nom"+i, passwordEncoder.encode("password"+i), true, ROLES.ROLE_ADMINISTRATEUR));
		}
		for(int i=3 ; i<6 ; i++) {
			list.add(new Utilisateur("nom"+i, passwordEncoder.encode("password"+i), true, ROLES.ROLE_UTILISATEUR));
		}
		
		return list;
	}

	private List<Periode> initPeriodes() {
		List<Periode> list = new ArrayList<>();
		
		for(int i=0 ; i<12 ; i++) {
			Periode p = new Periode();
			p.setDateDebut(LocalDate.of(LocalDate.now().getYear(), i+1, 1));
			p.setDateFin(p.getDateDebut().with(TemporalAdjusters.lastDayOfMonth()));
			list.add(p);
		}
		
		return list;
	}

}
