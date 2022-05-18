package fr.humanbooster.fx.calendrier_gif.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.service.EmotionService;
import fr.humanbooster.fx.calendrier_gif.service.GifService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ReactionController {
	
	public final GifService gifService;
	public final EmotionService emotionService;
	
	@GetMapping("reaction")
	public ModelAndView reactionsGet(@RequestParam(name="gif_id") Long id) {
		ModelAndView mav = new ModelAndView();
		
		Gif gif = gifService.recupererGif(id);
		
		mav.addObject("gif", gif);
		
		mav.addObject("emotions", emotionService.recupererEmotions());
		
		mav.setViewName("reaction");
		
		return mav;
	}

}
