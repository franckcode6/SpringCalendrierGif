package fr.humanbooster.fx.calendrier_gif.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.service.GifService;
import fr.humanbooster.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GifController {

	protected static final String DOSSIER_IMAGES = "src/main/webapp/images/";
	private static Long compteurGif = 1L;

	private final GifService gifService;
	private final JourService jourService;
	private final HttpSession httpSession;

	/**
	 * Affichage de la vue gifDistant
	 * 
	 * @return
	 */
	@GetMapping("gifdistant")
	public ModelAndView gifDistantGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("gifDistant");

		return mav;
	}

	/**
	 * Ajout d'un nouveau gif distant
	 * 
	 * @param date
	 * @param url
	 * @param legende
	 * @return
	 */
	@PostMapping("gifdistant")
	public ModelAndView gifDistantPost(@RequestParam(name = "date") String date, @RequestParam(name = "URL") String url,
			@RequestParam(name = "LEGENDE") String legende) {
		LocalDate data = LocalDate.parse(date);
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		gifService.ajouterGifDistant(url, legende, jourService.recupererJour(data), utilisateur);

		return new ModelAndView("redirect:calendrier");
	}

	/**
	 * Affichage de la vue gifTeleverse
	 * 
	 * @return
	 */
	@GetMapping("gifteleverse")
	public ModelAndView gifTeleverseGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("gifTeleverse");

		return mav;
	}

	/**
	 * Ajout d'un gif téléversé
	 * 
	 * @param date
	 * @param legende
	 * @param fichier
	 * @return
	 * @throws IOException
	 */
	@PostMapping("gifteleverse")
	public ModelAndView gifTeleversePost(@RequestParam(name = "date") String date,
			@RequestParam(name = "legende") String legende, @RequestParam("fichier") MultipartFile fichier)
			throws IOException {
		LocalDate data = LocalDate.parse(date);
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");

		// Création du nom de fichier
		String nomFichierOriginal = "image" + compteurGif + ".gif";
		compteurGif++;

		///////////////////////////
		// ZONE DE TURBULENCE
		enregisterFichier(nomFichierOriginal, fichier);
		// FIN DE ZONE DE TURBULENCE
		///////////////////////////

		gifService.ajouterGifTeleverse(nomFichierOriginal, legende, jourService.recupererJour(data), utilisateur);

		return new ModelAndView("redirect:calendrier");
	}

	/**
	 * Méthode de folie de FX pour enregistrer des images
	 * 
	 * @param nom
	 * @param multipartFile
	 * @throws IOException
	 */
	protected static void enregisterFichier(String nom, MultipartFile multipartFile) throws IOException {
		Path chemin = Paths.get(DOSSIER_IMAGES);

		if (!Files.exists(chemin)) {
			Files.createDirectories(chemin);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path cheminFichier = chemin.resolve(nom);
			Files.copy(inputStream, cheminFichier, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			throw new IOException("Erreur d'écriture : " + nom, ioe);
		}
	}
}