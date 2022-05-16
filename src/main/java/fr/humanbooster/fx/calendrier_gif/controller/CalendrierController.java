package fr.humanbooster.fx.calendrier_gif.controller;


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

	private final JourService jourService;

	/**
	 * Méthode permettant de générer la page de calendrier On y inclut la totalité
	 * des jours en BDD
	 * 
	 * @return
	 */
	@GetMapping("calendrier")
	public ModelAndView calendrierGet(@PageableDefault(size=10) Pageable pageable) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("jours", jourService.recupererJours());
		mav.addObject("pages", jourService.recupererJours(pageable));
		mav.setViewName("calendrier");
		return mav;
	}
}
