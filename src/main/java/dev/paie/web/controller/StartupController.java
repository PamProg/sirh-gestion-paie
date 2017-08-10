package dev.paie.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesServiceDev;

@Controller
public class StartupController {

	@Autowired InitialiserDonneesServiceDev initDonnees;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// code exécuté une fois que le contexte Spring est entièrement chargé
		
		initDonnees.initialiser();
	}
}