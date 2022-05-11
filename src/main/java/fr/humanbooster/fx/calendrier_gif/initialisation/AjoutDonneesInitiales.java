package fr.humanbooster.fx.calendrier_gif.initialisation;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;
import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Theme;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.dao.EmotionDao;
import fr.humanbooster.fx.calendrier_gif.dao.JourDao;
import fr.humanbooster.fx.calendrier_gif.dao.ThemeDao;
import fr.humanbooster.fx.calendrier_gif.dao.UtilisateurDao;
import lombok.AllArgsConstructor;

//grace à cette annotation Spring va ajouter une instance de cette classe dans son conteneur
@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final EmotionDao emotionDao;
	private final ThemeDao themeDao;
	private final JourDao jourDao;
	private final UtilisateurDao utilisateurDao;

	private static FakeValuesService fakeValuesService = new FakeValuesService(new Locale("fr-FR"),
			new RandomService());
	private final Faker faker = new Faker(new Locale("fr-FR"));

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Ajout");
		emotionDao.save(new Emotion("Souriant", "&#x1F600;"));
		emotionDao.save(new Emotion("Monocle", "&#x1F9D0;"));
		emotionDao.save(new Emotion("Bisous", "&#x1F618;"));
		emotionDao.save(new Emotion("Coeur", "&#x1F60D;"));
		emotionDao.save(new Emotion("PTDR", "&#x1F923;"));

		System.out.println("ajout themes:");
		themeDao.save(new Theme("dark"));
		themeDao.save(new Theme("bachata"));
		themeDao.save(new Theme("bootstrap"));

		System.out.println("ajout jours:");
		int anneeEnCours = LocalDate.now().getYear();
		int moisEnCours = LocalDate.now().getMonthValue();
		LocalDate localDate = LocalDate.of(anneeEnCours, moisEnCours, 1);
		int nbJoursDuMoisEnCours = localDate.lengthOfMonth();
		for (int i = 1; i <= nbJoursDuMoisEnCours; i++) {
			jourDao.save(new Jour(localDate));
			localDate = localDate.plusDays(1);
		}

		System.out.println("ajout utilisateurs");

		utilisateurDao.save(new Utilisateur("Quasevi", "Franck", "franck@hb.com", "12345", themeDao.getById(1L)));

		utilisateurDao.save(new Utilisateur("Toto", "Titi", "titi@hb.com", "12345", themeDao.getById(2L)));

		utilisateurDao.save(new Utilisateur("Choquet", "Laurent", "laurent@hb.com", "12345", themeDao.getById(2L)));

		utilisateurDao.save(new Utilisateur("Gomez", "Jeanne", "jeanne@hb.com", "12345", themeDao.getById(1L)));

		utilisateurDao.save(new Utilisateur(faker.name().lastName(), faker.name().firstName(), "john@hb.com", "12345",
				themeDao.getById(1L)));

	}
}
