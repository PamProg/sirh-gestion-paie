package dev.paie.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRenumerationRepository;

@Controller
@RequestMapping("/employes")
public class RemunerationEmployeController {
	
	@Autowired private EntrepriseRepository entrepriseRepo;
	@Autowired private ProfilRenumerationRepository profilRepo;
	@Autowired private GradeRepository gradeRepo;
	
	@RequestMapping(method = RequestMethod.GET, path = "/creer")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("employes/creerEmploye");
		
		List<Entreprise> entreprises = entrepriseRepo.findAll();
		mv.addObject("entreprises", entreprises);
		
		List<ProfilRemuneration> profils = profilRepo.findAll();
		mv.addObject("profils", profils);
		
		List<Grade> grades = gradeRepo.findAll();
		mv.addObject("grades", grades);
		
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/creer")
	public ModelAndView creerEmployePost(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		
		String matricule = req.getParameter("matricule");
		String 
		
		return mv;
	}
}