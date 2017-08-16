package dev.paie.config.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;

@Configuration
@Aspect
public class ControllerPerformanceAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);

	@Autowired private PerformanceRepository performanceRepo;
	
	@Around("execution(* dev.paie.web.controller.*.*(..))")
	public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
		
		String nomService = pjp.getSignature().toString();
		Long debut = System.currentTimeMillis();
		
		LOGGER.debug("Début d'exécution de la méthode " + nomService);
		Object resultat = pjp.proceed();
		LOGGER.debug("Fin d'exécution de la méthode");
		
		Long fin = System.currentTimeMillis();
		Long tempsExecution = fin - debut;
		LocalDateTime dateHeure = LocalDateTime.now();
		
		performanceRepo.save(new Performance(nomService, dateHeure, tempsExecution));
		
		return resultat;
	}
}