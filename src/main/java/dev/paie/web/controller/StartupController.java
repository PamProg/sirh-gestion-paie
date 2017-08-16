package dev.paie.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import dev.paie.service.InitialiserDonneesServiceDev;

/**
 * Controleur initialisant nos données via un listener
 * @author ETY15
 *
 */
@Controller
public class StartupController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StartupController.class);
	
	@Autowired InitialiserDonneesServiceDev initDonnees;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// code exécuté une fois que le contexte Spring est entièrement chargé
		
		LOGGER.info("Initialisation des données");
		
		initDonnees.initialiser();
	}
}