package dev.paie.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Cotisation;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = {JpaConfig.class, ServicesConfig.class, DataSourceMySQLConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class CotisationServiceJpaTest {
	
	@Autowired
	private CotisationService cotisationService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder une nouvelle cotisation
		// TODO vérifier qu'il est possible de récupérer la nouvelle cotisation via la
		// méthode lister
		// TODO modifier une cotisation
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode lister
		
		Cotisation nouvelleCotisation = new Cotisation();
		nouvelleCotisation.setCode("SCP");
		nouvelleCotisation.setLibelle("La cotisation qui est super !");
		nouvelleCotisation.setTauxSalarial(new BigDecimal("12.5"));
		nouvelleCotisation.setTauxPatronal(new BigDecimal("15.5"));
		cotisationService.sauvegarder(nouvelleCotisation);
	
		List<Cotisation> listeCotisations = cotisationService.lister();
		assertThat(listeCotisations.get(0).getCode()).isEqualTo("SCP");
		
		nouvelleCotisation.setCode("ABC");
		nouvelleCotisation.setLibelle("La cotisation qui est vraiment génial !");
		nouvelleCotisation.setTauxSalarial(new BigDecimal("20.5"));
		nouvelleCotisation.setTauxPatronal(new BigDecimal("32.5"));
		cotisationService.mettreAJour(nouvelleCotisation);
		
		listeCotisations = cotisationService.lister();
		assertThat(listeCotisations.get(0).getCode()).isEqualTo("ABC");
		
	}
}
