package dev.paie.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;
import dev.paie.repository.BulletinSalaireRepository;

@Service
public class GestionTransactionBulletin {

	@Autowired private BulletinSalaireRepository bulletinRepo;
	@Autowired private CalculerRemunerationService calculRemuneration;
	
	@Transactional
	public Map<BulletinSalaire, ResultatCalculRemuneration> getMapBulletinsCalculs() {
		
		List<BulletinSalaire> bulletinsCalculs = bulletinRepo.findAll();
		List<ResultatCalculRemuneration> resultatsCalcul = bulletinsCalculs.stream()
																			.map(b -> calculRemuneration.calculer(b))
																			.collect(Collectors.toList());
		
		// https://stackoverflow.com/questions/3618691/best-way-in-java-to-merge-two-lists-to-one-map
		Iterator<BulletinSalaire> bulletinItr = bulletinsCalculs.iterator();
		Iterator<ResultatCalculRemuneration> resultatsItr = resultatsCalcul.iterator();
		Map<BulletinSalaire, ResultatCalculRemuneration> map = new HashMap<>();
		while(bulletinItr.hasNext() && resultatsItr.hasNext()) {
			map.put(bulletinItr.next(), resultatsItr.next());
		}
		
		return map;
	}

	
}
