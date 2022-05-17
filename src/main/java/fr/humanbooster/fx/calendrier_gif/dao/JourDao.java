package fr.humanbooster.fx.calendrier_gif.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;

public interface JourDao extends JpaRepository<Jour, LocalDate> {

	/**
	 * Méthode permettant de trouver des Gif posté par un utilisateur
	 * 
	 * @param utilisateur
	 * @return
	 */
	List<Jour> findByGifContaining(Utilisateur utilisateur);

	/**
	 * Renvoie la liste des jours sur lesquels il n'y pas d'image
	 * 
	 * @return
	 */
	List<Jour> findByGifIsNull();

	/**
	 * Renvoie la liste des jours nulls et plus grands ou égaux au nbPoints
	 * 
	 * @param points
	 * @return
	 */
	List<Jour> findByGifIsNullAndNbPointsGreaterThanEqual(int points);

	/**
	 * Renvoie la liste des jours nulls et plus grands ou égaux au nbPoints donné et
	 * dont la date est anterieure au paramatre donné
	 * 
	 * @param points
	 * @param date
	 * @return
	 */
	List<Jour> findByGifIsNullAndNbPointsGreaterThanEqualAndDateBefore(int points, LocalDate date);
	
	Jour findFirstByOrderByDateDesc();
}
