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
import dev.paie.entite.Grade;
import dev.paie.spring.DataSourceMySQLConfig;

//Sélection des classes de configuration Spring à utiliser lors du test
@ContextConfiguration(classes = {DataSourceMySQLConfig.class, ServicesConfig.class})
//Configuration JUnit pour que Spring prenne la main sur le cycle de vie du test
@RunWith(SpringRunner.class)
public class GradeServiceJdbcTemplateTest {

	@Autowired
	private GradeService gradeService;

	@Test
	public void test_sauvegarder_lister_mettre_a_jour() {
	// TODO sauvegarder un nouveau grade
	// TODO vérifier qu'il est possible de récupérer le nouveau grade via la m
//	éthode lister
	// TODO modifier un grade
	// TODO vérifier que les modifications sont bien prises en compte via la m
//	éthode lister
		
		Grade nouveauGrade = new Grade();
		nouveauGrade.setCode("Super chef");
		nouveauGrade.setNbHeuresBase(new BigDecimal("35"));
		nouveauGrade.setTauxBase(new BigDecimal("12.5"));
		gradeService.sauvegarder(nouveauGrade);
		
		List<Grade> listeGrades = gradeService.lister();
		assertThat(listeGrades.get(0).getCode()).isEqualTo("Super chef");
		
		nouveauGrade = listeGrades.get(0);
		nouveauGrade.setCode("CEO");
		nouveauGrade.setNbHeuresBase(new BigDecimal("40"));
		nouveauGrade.setTauxBase(new BigDecimal("15"));
		gradeService.mettreAJour(nouveauGrade);
		
		listeGrades = gradeService.lister();
		assertThat(listeGrades.get(0).getCode()).isEqualTo("CEO");
		
	}
}
