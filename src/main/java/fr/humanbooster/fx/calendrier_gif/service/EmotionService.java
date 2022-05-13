package fr.humanbooster.fx.calendrier_gif.service;

import java.util.List;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;

public interface EmotionService {
	
	List<Emotion> recupererEmotions();

	void ajouterEmotion(String nom, String code);

	void effacerEmotion(Emotion emotion);

}
