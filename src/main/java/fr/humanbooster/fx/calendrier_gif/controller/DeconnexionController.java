package fr.humanbooster.fx.calendrier_gif.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DeconnexionController {

	private final HttpServletRequest request;

	/**
	 * Méthode permettant de déconnecter l'utilisateur et de le rediriger vers la
	 * page index
	 * 
	 * @return
	 */
	@GetMapping("deconnexion")
	public ModelAndView deconnexionGet() {
		request.getSession().invalidate();
		return new ModelAndView("redirect:index");
	}
}
