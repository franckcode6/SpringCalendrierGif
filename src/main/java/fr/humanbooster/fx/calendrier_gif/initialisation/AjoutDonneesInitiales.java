package fr.humanbooster.fx.calendrier_gif.initialisation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
	private List<Utilisateur> utilisateurs;
	private List<Jour> jours;
	private List<Emotion> emotions;
	private List<Theme> themes;

	@Override
	public void run(String... args) throws Exception {
		Date dateDebut = new Date();

		// EMOTIONS
		ajouterEmotions();

		// THEMES
		ajouterThemes();

		// JOURS
		ajouterJours();

		// UTILISATEURS
		ajouterUtilisateurParDéfaut();
		ajouterUtilisateurs();

		Date dateFin = new Date();
		System.out.println(dateFin.getTime() - dateDebut.getTime());
	}

	/**
	 * Ajout des émotions
	 */
	private void ajouterEmotions() {
		System.out.println("Ajout des émotions");
		emotions.add(new Emotion("Souriant", "&#x1F600;"));
		emotions.add(new Emotion("Monocle", "&#x1F9D0;"));
		emotions.add(new Emotion("Bisous", "&#x1F618;"));
		emotions.add(new Emotion("Coeur", "&#x1F60D;"));
		emotions.add(new Emotion("PTDR", "&#x1F923;"));
		emotionDao.saveAll(emotions);
	}

	/**
	 * Ajout des thèmes
	 */
	private void ajouterThemes() {
		System.out.println("Ajout des thèmes");
		themes.add(new Theme("Dark"));
		themes.add(new Theme("Bachata"));
		themeDao.saveAll(themes);
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
			jours.add(new Jour(localDate));
			localDate = localDate.plusDays(1);
		}
		jourDao.saveAll(jours);
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
		for (int i = 0; i < 5000; i++) {
			// Utilisateurs possédant le thème 1
			utilisateurs
					.add(new Utilisateur(
							faker.date().past(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault())
									.toLocalDateTime(),
							faker.name().lastName(), faker.name().firstName(), faker.name().firstName() + "@hb.com",
							faker.internet().password(), themeDao.getById(1L)));
			// Utilisateurs possédant le thème 2
			utilisateurs
					.add(new Utilisateur(
							faker.date().past(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault())
									.toLocalDateTime(),
							faker.name().lastName(), faker.name().firstName(), faker.name().firstName() + "@hb.com",
							faker.internet().password(), themeDao.getById(2L)));
		}
		utilisateurDao.saveAll(utilisateurs);
	}
}
