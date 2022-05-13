package fr.humanbooster.fx.calendrier_gif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.service.EmotionService;
import fr.humanbooster.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CalendrierGifController {

	private final UtilisateurService utilisateurService;
	private final EmotionService emotionService;

	// Toutes les méthodes de ce controller devront renvoyer un objet de type
	// ModelAndView
	// Métaphore de la danette Pop :)
	// On indique sur quelles URLs la méthode va écouter
	// Autrement dit quelle(s) sont la ou les URL(s) que la méthode prend en charge
	// Equivalent de @WebServlet
	@RequestMapping({ "/index", "/" })
	public ModelAndView acceuil() {
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

	//Emotions
	@RequestMapping("/emotions")
	public ModelAndView emotionGetAll() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("emotion");

		mav.addObject("emotions", emotionService.recupererEmotions());
		return mav;
	}
}
