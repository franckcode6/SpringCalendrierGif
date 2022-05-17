package fr.humanbooster.fx.calendrier_gif.service.impl;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.calendrier_gif.business.GifDistant;
import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.dao.GifDistantDao;
import fr.humanbooster.fx.calendrier_gif.service.GifDistantService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GifDistantServiceImpl implements  GifDistantService {

	private final GifDistantDao gifDistantDao;
	
	@Override
	public void ajouterGifDistant(String url, String legende, Jour jour, Utilisateur utilisateur) {
		gifDistantDao.save(new GifDistant(url, legende, jour, utilisateur));
	}
}
