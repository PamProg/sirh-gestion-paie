package dev.paie.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import dev.paie.config.ServicesConfig;
import dev.paie.entite.Avantage;
import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = {JpaConfig.class, ServicesConfig.class, DataSourceMySQLConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class AvantageRepositoryTest {

	@Autowired
	private AvantageRepository avantageRepository;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
		// TODO sauvegarder un nouvel avantage
		// TODO vérifier qu'il est possible de récupérer le nouvel avantage via
		// la méthode findOne
		// TODO modifier un avantage
		// TODO vérifier que les modifications sont bien prises en compte via la
		// méthode findOne
		
		Avantage nouvelAvantage = new Avantage();
		nouvelAvantage.setId(1);
		nouvelAvantage.setCode("CODEA");
		nouvelAvantage.setNom("Super avantage");
		nouvelAvantage.setMontant(new BigDecimal("200"));
		avantageRepository.save(nouvelAvantage);
		
		Avantage avantageRecup = avantageRepository.findOne(1);
		assertThat(avantageRecup.getCode()).isEqualTo("CODEA");
		
		Avantage avantageAMettreAJour = avantageRepository.findOne(1);
		avantageAMettreAJour.setCode("CODEB");
		avantageAMettreAJour.setNom("Super avantage génial trop fort !");
		avantageAMettreAJour.setMontant(new BigDecimal("1000"));
		avantageRepository.save(avantageAMettreAJour);
		
		avantageRecup = avantageRepository.findOne(1);
		assertThat(avantageRecup.getCode()).isEqualTo("CODEB");
	}
	
	@Test
	public void test_chercher_par_code() {
		String code = "CODEC";
		
		Avantage nouvelAvantage = new Avantage();
		nouvelAvantage.setId(1);
		nouvelAvantage.setCode(code);
		nouvelAvantage.setNom("Super avantage");
		nouvelAvantage.setMontant(new BigDecimal("200"));
		avantageRepository.save(nouvelAvantage);
		
		Avantage av = avantageRepository.findOneByCode(code);
		assertThat(av.getCode()).isEqualTo(code);
	}
}
