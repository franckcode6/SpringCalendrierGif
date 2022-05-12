package fr.humanbooster.fx.calendrier_gif.initialisation;

import java.time.LocalDate;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.github.javafaker.Faker;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;
import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Theme;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.dao.EmotionDao;
import fr.humanbooster.fx.calendrier_gif.dao.JourDao;
import fr.humanbooster.fx.calendrier_gif.dao.ThemeDao;
import fr.humanbooster.fx.calendrier_gif.dao.UtilisateurDao;
import lombok.AllArgsConstructor;

//Grace à cette annotation Spring va ajouter une instance de cette classe dans son conteneur
@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final EmotionDao emotionDao;
	private final ThemeDao themeDao;
	private final JourDao jourDao;
	private final UtilisateurDao utilisateurDao;
	private final Faker faker = new Faker(new Locale("fr-FR"));

	@Override
	public void run(String... args) throws Exception {

		// EMOTIONS
		ajouterEmotions();

		// THEMES
		ajouterThemes();

		// JOURS
		ajouterJours();

		// UTILISATEURS
		ajouterUtilisateurParDéfaut();
		ajouterUtilisateurs();
	}

	/**
	 * Ajout des émotions
	 */
	private void ajouterEmotions() {
		System.out.println("Ajout des émotions");
		emotionDao.save(new Emotion("Souriant", "&#x1F600;"));
		emotionDao.save(new Emotion("Monocle", "&#x1F9D0;"));
		emotionDao.save(new Emotion("Bisous", "&#x1F618;"));
		emotionDao.save(new Emotion("Coeur", "&#x1F60D;"));
		emotionDao.save(new Emotion("PTDR", "&#x1F923;"));
	}

	/**
	 * Ajout des thèmes
	 */
	private void ajouterThemes() {
		System.out.println("Ajout des thèmes");
		themeDao.save(new Theme("Dark"));
		themeDao.save(new Theme("Bachata"));
	}

	/**
	 * Ajout des jours
	 */
	private void ajouterJours() {
		System.out.println("Ajout des jours");
		int anneeEnCours = LocalDate.now().getYear();
		int moisEnCours = LocalDate.now().getMonthValue();
		LocalDate localDate = LocalDate.of(anneeEnCours, moisEnCours, 1);
		int nbJoursDuMoisEnCours = localDate.lengthOfMonth();
		for (int i = 1; i <= nbJoursDuMoisEnCours; i++) {
			jourDao.save(new Jour(localDate));
			localDate = localDate.plusDays(1);
		}
	}

	/**
	 * Ajout d'un utilisateur par défaut
	 */
	private void ajouterUtilisateurParDéfaut() {
		System.out.println("Ajout utilisateur par défaut");
		utilisateurDao.save(new Utilisateur("Quasevi", "Franck", "franck@hb.com", "12345", themeDao.getById(2L)));
	}

	/**
	 * Ajout des utilisateurs randoms
	 */
	private void ajouterUtilisateurs() {
		System.out.println("Ajout des utilisateurs");
		// Creation d'une boucle pour générer des utilisateurs aléatoires
		for (int i = 0; i < 5; i++) {
			// Utilisateurs possédant le thème 1
			utilisateurDao.save(new Utilisateur(faker.name().lastName(), faker.name().firstName(),
					faker.internet().emailAddress(), faker.internet().password(), themeDao.getById(1L)));
			// Utilisateurs possédant le thème 2
			utilisateurDao.save(new Utilisateur(faker.name().lastName(), faker.name().firstName(),
					faker.name().firstName() + "@hb.com", faker.internet().password(), themeDao.getById(2L)));
		}
	}
}
