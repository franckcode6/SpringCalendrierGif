package fr.humanbooster.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;
import fr.humanbooster.fx.calendrier_gif.dao.EmotionDao;
import fr.humanbooster.fx.calendrier_gif.service.EmotionService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmotionServiceImpl implements EmotionService {
	
	private final EmotionDao emotionDao;
	
	public List<Emotion> recupererEmotions() {
		return emotionDao.findAll();
	}
	

}
