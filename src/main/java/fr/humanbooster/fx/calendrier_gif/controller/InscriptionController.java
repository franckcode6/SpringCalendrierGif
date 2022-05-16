package fr.humanbooster.fx.calendrier_gif.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.service.ThemeService;
import fr.humanbooster.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class InscriptionController {

	private final ThemeService themeService;
	private final UtilisateurService utilisateurService;

	/**
	 * Principe Hollywood; ne nous appelez pas, nous vous appelerons
	 * 
	 * @param utilisateur
	 * @return
	 */
	@GetMapping("inscription")
	public ModelAndView inscriptionGet(@ModelAttribute Utilisateur utilisateur) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("theme", themeService.recupererThemes());

		mav.setViewName("inscription");

		return mav;
	}

	/**
	 * Méthode invoquée quand l'utilisateur clique sur le bouton inscription
	 * 
	 * @param utilisateur
	 * @param result
	 * @return
	 */
	@PostMapping("inscription")
	public ModelAndView inscriptionPost(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
			BindingResult result) {

		if (result.hasErrors()) {
			// La validation de l’objet utilisateur par rapport aux contraintes
			// de validation définies dans la classe métier Utilisateur a produit
			// des erreurs
			ModelAndView mav = inscriptionGet(utilisateur);
			return mav;
		} else {
			utilisateurService.ajouterUtilisateur(utilisateur);
			return new ModelAndView("redirect:index");
		}
	}

}
