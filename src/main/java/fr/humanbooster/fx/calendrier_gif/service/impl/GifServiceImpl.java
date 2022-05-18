package fr.humanbooster.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.calendrier_gif.business.Gif;
import fr.humanbooster.fx.calendrier_gif.business.GifDistant;
import fr.humanbooster.fx.calendrier_gif.business.GifTeleverse;
import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.dao.GifDao;
import fr.humanbooster.fx.calendrier_gif.dao.GifDistantDao;
import fr.humanbooster.fx.calendrier_gif.dao.GifTeleverseDao;
import fr.humanbooster.fx.calendrier_gif.dao.UtilisateurDao;
import fr.humanbooster.fx.calendrier_gif.service.GifService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GifServiceImpl implements GifService {

	private final GifDistantDao gifDistantDao;
	private final GifTeleverseDao gifTeleverseDao;
	private final GifDao gifDao;
	private final UtilisateurDao utilisateurDao;

	@Override
	public Gif ajouterGifDistant(String url, String legende, Jour jour, Utilisateur utilisateur) {
		GifDistant gifDistant = gifDistantDao.save(new GifDistant(url, legende, jour, utilisateur));

		// En ajoutant mappedBy comme suit : @OneToOne(mappedBy = "jour")
		// le code suivant n'est plus nécessaire
		// Jour jour = jourService.recupererJour(gifDistant.getJour().getDate());
		// jour.setGif(gifDistant);
		// jourService.enregistrerJour(jour);

		// Met à jour le solde de l'utilisateur
		utilisateur.setNbPoints(utilisateur.getNbPoints() - gifDistant.getJour().getNbPoints());
		utilisateurDao.save(utilisateur);
		return gifDistant;
	}

	@Override
	public GifTeleverse ajouterGifTeleverse(String nomFichierOriginal, String legende, Jour jour,
			Utilisateur utilisateur) {
		return gifTeleverseDao.save(new GifTeleverse(nomFichierOriginal, legende, jour, utilisateur));
	}

	@Override
	public Gif enregistrerGif(Gif gif) {
		return gifDao.save(gif);
	}

	@Override
	public Gif recupererGif(Long idGif) {
		return gifDao.findById(idGif).orElse(null);
	}

	@Override
	public Gif modifierLegende(Long id, String legende) {
		Gif gif = this.recupererGif(id);
		gif.setLegende(legende);
		return gifDao.save(gif);
	}

	@Override
	public Gif recupererGifParJour(Jour jour) {
		Gif gif = gifDao.findByJour(jour);
		return gif;
	}
	
	@Override
	public List<Gif> recupererGifsParLegende(String legende) {
		List<Gif> gifs = gifDao.findGifsByLegende(legende);
		return gifs;
	}
}
