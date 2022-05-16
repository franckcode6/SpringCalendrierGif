package fr.humanbooster.fx.calendrier_gif.service;

import java.util.List;

import fr.humanbooster.fx.calendrier_gif.business.Theme;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.util.NbInscrits;

public interface UtilisateurService {

	Utilisateur recupererUtilisateur(String email, String motDePasse);
	
	List<NbInscrits> recupererNbInscrits();

	Long compterUtilisateurs();

	void ajouterUtilisateur(String nom, String prenom, String email, String motDePasse, Theme theme);

	void ajouterUtilisateur(Utilisateur utilisateur);
}
