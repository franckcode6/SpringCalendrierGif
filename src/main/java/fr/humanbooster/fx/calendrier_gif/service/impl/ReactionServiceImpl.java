package fr.humanbooster.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;
import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.business.Reaction;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.dao.ReactionDao;
import fr.humanbooster.fx.calendrier_gif.service.ReactionService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReactionServiceImpl implements ReactionService {
	
	private final ReactionDao reactionDao;
	
	@Override
	public void ajouterReaction(Gif gif, Emotion emotion, Utilisateur utilisateur) {
		reactionDao.save(new Reaction(gif, emotion, utilisateur));
	}
	
	@Override
	public List<Reaction> recupererReactions() {
		return reactionDao.findAll();
	}

}
