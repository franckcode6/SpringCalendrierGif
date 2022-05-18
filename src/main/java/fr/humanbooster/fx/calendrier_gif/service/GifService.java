package fr.humanbooster.fx.calendrier_gif.service;

import java.util.List;

import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.business.GifTeleverse;
import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;

public interface GifService {

	Gif ajouterGifDistant(String url, String legende, Jour jour, Utilisateur utilisateur);

	GifTeleverse ajouterGifTeleverse(String nomFichierOriginal, String legende, Jour jour, Utilisateur utilisateur);

	Gif enregistrerGif(Gif gif);

	Gif recupererGif(Long idGif);

	Gif modifierLegende(Long id, String legende);

	Gif recupererGifParJour(Jour jour);

	List<Gif> recupererGifsParLegende(String legende);

}
