package fr.humanbooster.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.calendrier_gif.business.Theme;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.dao.UtilisateurDao;
import fr.humanbooster.fx.calendrier_gif.service.UtilisateurService;
import fr.humanbooster.fx.calendrier_gif.util.NbInscrits;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

	//Attributs de la classe de service (== ses dépendances)
	private final UtilisateurDao utilisateurDao;
	
	@Override
	public Utilisateur recupererUtilisateur(String email, String motDePasse) {
		return utilisateurDao.findByEmailAndMotDePasse(email, motDePasse);
	}

	@Override
	public List<NbInscrits> recupererNbInscrits() {
		return utilisateurDao.findNbInscrits();
	}

	@Override
	public Long compterUtilisateurs() {
		return utilisateurDao.count();
	}

	@Override
	public void ajouterUtilisateur(String nom, String prenom, String email, String motDePasse, Theme theme) {
		utilisateurDao.save(new Utilisateur(nom, prenom, email, motDePasse, theme));
	}

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		utilisateurDao.save(utilisateur);
	}

}
