package fr.humanbooster.fx.calendrier_gif.controller;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CalendrierController {

	private static final int NB_JOURS_PAR_PAGE = 7;
	
	private final JourService jourService;
	private final HttpSession httpSession;
	
	/**
	 * Méthode permettant de générer la page de calendrier On y inclut la totalité
	 * des jours en BDD
	 * 
	 * @return
	 */
	@GetMapping("calendrier")
	public ModelAndView calendrierGet(@PageableDefault(size = NB_JOURS_PAR_PAGE, sort = "date") Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("jours", jourService.recupererJours());
		mav.setViewName("calendrier");
		mav.addObject("pageDeJours", jourService.recupererJours(pageable));
		// Met en session la page choisie
		if (pageable!=null) {
			httpSession.setAttribute("numeroDePage", pageable.getPageNumber());
		}
		return mav;
	}
}
