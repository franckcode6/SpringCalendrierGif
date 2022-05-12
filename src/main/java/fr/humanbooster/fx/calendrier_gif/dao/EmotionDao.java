package fr.humanbooster.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;

public interface EmotionDao extends JpaRepository<Emotion, Long> {

	//L'annotation @Query acceuille par défaut une requête HQL
	@Query("FROM Emotion WHERE nom LIKE 's%'")
	List<Emotion> findEmotionStartingWithS();
	
	/**
	 * Retourne les 2eres émotions par nom
	 * @param nom
	 * @return
	 */
	List<Emotion> findFirst2ByNomContaining(String nom);
}
