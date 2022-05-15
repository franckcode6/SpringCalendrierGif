package fr.humanbooster.fx.calendrier_gif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.business.Theme;
import fr.humanbooster.fx.calendrier_gif.service.EmotionService;
import fr.humanbooster.fx.calendrier_gif.service.ThemeService;
import fr.humanbooster.fx.calendrier_gif.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CalendrierGifController {

	private final UtilisateurService utilisateurService;
	private final EmotionService emotionService;
	private final ThemeService themeService;

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

	// Méthode invoquée lorsque que quelqu'un se rend sur /emotions
	@GetMapping("/emotions")
	public ModelAndView emotionsGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("emotions");

		mav.addObject("emotions", emotionService.recupererEmotions());
		return mav;
	}

	// Méthode invoquée lorsque que quelqu'un se rend sur le formulaire contenu dans
	// /emotion
	@GetMapping("emotion")
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
	@PostMapping("emotion")
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

	// Méthode invoquée lorsque l'utilisateur se rend sur /inscription
	@GetMapping("inscription")
	public ModelAndView inscriptionGet() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("themes", themeService.recupererThemes());

		mav.setViewName("inscription");

		return mav;
	}

	// Méthode invoquée quand l'utilisateur clique sur le bouton inscription
	@PostMapping("inscription")
	public ModelAndView inscriptionPost(@RequestParam(name = "NOM") String nom,
			@RequestParam(name = "PRENOM") String prenom, @RequestParam(name = "EMAIL") String email,
			@RequestParam(name = "MOT_DE_PASSE") String motDePasse, @RequestParam(name = "THEME_ID") Long ID) {

		Theme theme = themeService.recupererTheme(ID);
		utilisateurService.ajouterUtilisateur(nom, prenom, email, motDePasse, theme);

		return new ModelAndView("redirect:index");

	}
}
