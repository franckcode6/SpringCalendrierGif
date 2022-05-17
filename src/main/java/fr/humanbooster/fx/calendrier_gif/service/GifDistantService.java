package fr.humanbooster.fx.calendrier_gif.service;

import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;

public interface GifDistantService {

	void ajouterGifDistant(String url, String legende, Jour jour, Utilisateur utilisateur);

}
