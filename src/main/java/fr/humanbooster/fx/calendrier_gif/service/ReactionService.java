package fr.humanbooster.fx.calendrier_gif.service;

import java.util.List;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;
import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.business.Reaction;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;

public interface ReactionService {

	void ajouterReaction(Gif gif, Emotion emotion, Utilisateur utilisateur);

	List<Reaction> recupererReactions();

}
