package fr.humanbooster.fx.calendrier_gif.service;

import java.util.List;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;

public interface EmotionService {
	
	List<Emotion> recupererEmotions();

	void ajouterEmotion(String nom, String code);
	
	Emotion recupererEmotion(Long id);
	
	public Emotion modifierEmotion(Long id, String nom, String code);

	void supprimerEmotion(Long id);

}
