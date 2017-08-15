package dev.paie.web.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Periode;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.repository.RemunerationEmployeRepository;
import dev.paie.service.CalculerRemunerationService;
import dev.paie.service.GestionFormulaireCreerBulletin;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {
	
	@Autowired private BulletinSalaireRepository bulletinRepo;
	@Autowired private RemunerationEmployeRepository employeRepo;
	@Autowired private PeriodeRepository periodeRepo;
	
	@Autowired private GestionFormulaireCreerBulletin gestionFormulaire;
	@Autowired private CalculerRemunerationService calculRemuneration;;
	
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	@RequestMapping(method = RequestMethod.GET, path = "/lister")
	public ModelAndView listerBulletins() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listerBulletins");
		
		List<BulletinSalaire> bulletins = bulletinRepo.findAll();
		mv.addObject("bulletins", bulletins);
		
		List<ResultatCalculRemuneration> resultatsCalcul = bulletins.stream()
																	.map(b -> calculRemuneration.calculer(b))
																	.collect(Collectors.toList());
		
		mv.addObject("resultats", resultatsCalcul);
		
		return mv;
	}
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerBulletinForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		
		List<Periode> periodes = periodeRepo.findAll();
		mv.addObject("periodes", periodes);
		
		List<RemunerationEmploye> employes = employeRepo.findAll();
		List<String> matricules = employes.stream().map(e -> e.getMatricule()).collect(Collectors.toList());
		mv.addObject("matricules", matricules);
		
		return mv;
	}
	
	@Secured("ROLE_ADMINISTRATEUR")
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public String creerEmployePost(HttpServletRequest req) {
		String periodeString = req.getParameter("periode");
		String matricule = req.getParameter("matricule");
		String prime = req.getParameter("prime");
		
		Periode periode = gestionFormulaire.getPeriodeWithString(periodeString);
		RemunerationEmploye employe = gestionFormulaire.getEmployeWithMatricule(matricule);
		
		bulletinRepo.save(new BulletinSalaire(employe, periode, new BigDecimal(prime), LocalDateTime.now()));
		
		return "redirect:/mvc/bulletins/creer";
	}
	
	
	@Secured({"ROLE_ADMINISTRATEUR", "ROLE_UTILISATEUR"})
	@RequestMapping(method = RequestMethod.GET, path = "/lister/{id}")
	public ModelAndView visualiserBulletin(@PathVariable Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/visualiserBulletin");
		
		BulletinSalaire bulletin = bulletinRepo.findOneById(id);
		mv.addObject("bulletin", bulletin);
		
		return mv;
	}
	
}
