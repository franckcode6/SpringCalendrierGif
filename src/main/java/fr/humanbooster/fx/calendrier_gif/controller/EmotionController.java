package fr.humanbooster.fx.calendrier_gif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.service.EmotionService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EmotionController {

	private final EmotionService emotionService;

	// Méthode invoquée lorsque que quelqu'un se rend sur /emotions
	@GetMapping("calendrier/emotions")
	public ModelAndView emotionsGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("emotions");

		mav.addObject("emotions", emotionService.recupererEmotions());
		return mav;
	}

	// Méthode invoquée lorsque que quelqu'un se rend sur le formulaire contenu dans
	// /emotion
	@GetMapping("calendrier/emotion")
	public ModelAndView emotionGet(@RequestParam(name = "ID", required = false, defaultValue = "0") Long id) {
		ModelAndView mav = new ModelAndView();

		// On ajoute dans le mav l'objet emotion (si un id d'emotion a été précisé dans
		// l'URL)
		mav.addObject("emotion", emotionService.recupererEmotion(id));
		mav.setViewName("emotion");
		return mav;
	}

	// Méthode invoquée lorsque que quelqu'un clique le bouton Ajouter du formulaire
	// contenu dans /emotion
	@PostMapping("calendrier/emotion")
	public ModelAndView emotionPost(@RequestParam(name = "ID", required = false) Long id,
			@RequestParam("NOM") String nom, @RequestParam("CODE") String code) {

		System.out.println("ID saisi sur le formulaire HTML : " + id);
		System.out.println("Nom saisi sur le formulaire HTML : " + nom);
		System.out.println("Code saisi sur le formulaire HTML : " + code);

		if (id == null) {
			emotionService.ajouterEmotion(nom, code);
		} else {
			emotionService.modifierEmotion(id, nom, code);
		}
		return new ModelAndView("redirect:emotions");
	}

	// Méthode permettant de supprimer une emotion
	@GetMapping("supprimerEmotion")
	public ModelAndView supprimerEmotionGet(@RequestParam(name = "ID", required = true) Long id) {
		emotionService.supprimerEmotion(id);
		System.out.println("Suppression de l'emotion id " + id);
		return new ModelAndView("redirect:emotions");
	}
}
