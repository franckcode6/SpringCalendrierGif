package fr.humanbooster.fx.calendrier_gif.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.service.GifService;
import fr.humanbooster.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GifController {

	private final GifService gifService;
	private final JourService jourService;
	private final HttpSession httpSession;

	@GetMapping("gifdistant")
	public ModelAndView gifDistantGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("gifDistant");

		return mav;
	}

	@PostMapping("gifdistant")
	public ModelAndView gifDistantPost(@RequestParam(name = "date") String date, @RequestParam(name = "URL") String url,
			@RequestParam(name = "LEGENDE") String legende) {
		LocalDate data = LocalDate.parse(date);
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		gifService.ajouterGifDistant(url, legende, jourService.recupererJour(data), utilisateur);

		return new ModelAndView("redirect:calendrier");
	}
	
	@GetMapping("gifteleverse")
	public ModelAndView gifTeleverseGet() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("gifTeleverse");

		return mav;
	}
}