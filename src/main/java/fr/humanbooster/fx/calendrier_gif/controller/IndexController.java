package fr.humanbooster.fx.calendrier_gif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {

	private final UtilisateurService utilisateurService;
	private final HttpServletRequest request;

	// Toutes les méthodes de ce controller devront renvoyer un objet de type
	// ModelAndView
	// Métaphore de la danette Pop :)
	// On indique sur quelles URLs la méthode va écouter
	// Autrement dit quelle(s) sont la ou les URL(s) que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping({ "/index", "/" })
	public ModelAndView index() {
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
	public ModelAndView indexPost(@RequestParam(name = "EMAIL") String email,
			@RequestParam(name = "MOT_DE_PASSE") String motDePasse) {
		if (utilisateurService.recupererUtilisateur(email, motDePasse) == null) {
			return new ModelAndView("redirect:index");
		} else {
			request.getSession().setAttribute("utilisateur",
					utilisateurService.recupererUtilisateur(email, motDePasse));
			System.out.println("CONNEXION OK");
			return new ModelAndView("redirect:calendrier");
		}

	}
}
