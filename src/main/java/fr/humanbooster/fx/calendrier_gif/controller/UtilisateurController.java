package fr.humanbooster.fx.calendrier_gif.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.service.ThemeService;
import fr.humanbooster.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class UtilisateurController {

	private final UtilisateurService utilisateurService;
	private final ThemeService themeService;
	private final HttpSession httpSession;

	// Toutes les méthodes de ce controller devront renvoyer un objet de type
	// ModelAndView
	// Métaphore de la danette Pop :)
	// On indique sur quelles URLs la méthode va écouter
	// Autrement dit quelle(s) sont la ou les URL(s) que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping({ "/index", "/" })
	public ModelAndView connexionGet() {
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();

		// On définit le nom de la vue (== creme dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("index");

		// On ajoute dans le modele la liste des nbs d'inscrits
		// Equivalent de request.setAttribute("nbInscrits,
		// utilisateurService.recupererNbInscrits()")
		mav.addObject("nbInscrits", utilisateurService.recupererNbInscrits());

		mav.getModel().put("nbTotalInscrits", utilisateurService.compterUtilisateurs());
		return mav;
	}

	/**
	 * Méthode appelée à la soumission du formulaire de connexion
	 * 
	 * @param email
	 * @param motDePasse
	 * @return
	 */
	@PostMapping({ "/index", "/" })
	public ModelAndView connexionPost(@RequestParam(name = "EMAIL") String email,
			@RequestParam(name = "MOT_DE_PASSE") String motDePasse) {
		if (utilisateurService.recupererUtilisateur(email, motDePasse) == null) {
			return new ModelAndView("redirect:index");
		} else {
			httpSession.setAttribute("utilisateur",
					utilisateurService.recupererUtilisateur(email, motDePasse));
			System.out.println("CONNEXION OK");
			return new ModelAndView("redirect:calendrier");
		}
	}

	/**
	 * Méthode permettant de déconnecter l'utilisateur et de le rediriger vers la
	 * page index
	 * 
	 * @return
	 */
	@GetMapping("deconnexion")
	public ModelAndView deconnexionGet() {
		httpSession.invalidate();
		return new ModelAndView("redirect:index");
	}

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
