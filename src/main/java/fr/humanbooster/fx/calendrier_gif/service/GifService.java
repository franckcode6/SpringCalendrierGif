package fr.humanbooster.fx.calendrier_gif.service;

import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.business.GifTeleverse;
import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;

public interface GifService {

	Gif ajouterGifDistant(String url, String legende, Jour jour, Utilisateur utilisateur);

	GifTeleverse ajouterGifTeleverse(String nomFichierOriginal, String legende, Jour jour, Utilisateur utilisateur);

}
