package fr.humanbooster.fx.calendrier_gif.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.service.EmotionService;
import fr.humanbooster.fx.calendrier_gif.service.GifService;
import fr.humanbooster.fx.calendrier_gif.service.ReactionService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReactionController {
	
	private final GifService gifService;
	private final ReactionService reactionService;
	private final EmotionService emotionService;
	private final HttpSession httpSession;
	
	
	@GetMapping("reaction")
	public ModelAndView reactionsGet(@RequestParam(name="gif_id") Long id) {
		ModelAndView mav = new ModelAndView();
		
		Gif gif = gifService.recupererGif(id);
		
		mav.addObject("gif", gif);
		mav.addObject("emotions", emotionService.recupererEmotions());
		mav.setViewName("reaction");
		
		return mav;
	}
	
	@PostMapping("reaction")
	public ModelAndView reactionPost(@RequestParam(name="gif_id") Long id,
			@RequestParam(name="emotion_id") Long emotionId) {
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		
		reactionService.ajouterReaction(gifService.recupererGif(id), emotionService.recupererEmotion(emotionId),
				utilisateur);
		
		return new ModelAndView("redirect:calendrier");
	}

}
