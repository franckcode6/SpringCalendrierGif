package fr.humanbooster.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.humanbooster.fx.calendrier_gif.business.Emotion;
import fr.humanbooster.fx.calendrier_gif.business.Theme;
import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;
import fr.humanbooster.fx.calendrier_gif.util.NbInscrits;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	// Query method (feature de Spring Data)
	// Spring Data va interpréter le noù de la méthode qui n'est pas annotée @Query
	// (requête par dérivation)
	Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);

	/**
	 * Liste les utilisateurs par thème
	 * 
	 * @param theme
	 * @return
	 */
	List<Utilisateur> findByTheme(Theme theme);

	/**
	 * Liste les utilisateurs par nom de thème
	 * 
	 * @param nom
	 * @return
	 */
	List<Utilisateur> findByThemeNom(String nom);

	/**
	 * Liste les utilisateurs ayant un total de points < seuil
	 * 
	 * @param seuil
	 * @return
	 */
	List<Utilisateur> findByNbPointsLessThan(int seuil);

	/**
	 * Permet de retrouver les utilisateurs avec une Emotion donnée
	 * 
	 * @param emotion
	 * @return
	 */
	List<Utilisateur> findByReactionsEmotion(Emotion emotion);

	/**
	 * Permet de retrouver les utilisateurs avec le nom d'une Emotion
	 * 
	 * @param emotion
	 * @return
	 */
	List<Utilisateur> findByReactionsEmotionNom(String nom);

	@Query(value = """
			FROM Utilisateur
			WHERE theme.nom = 'Dark'
			""")
	List<Utilisateur> findUserHavingChosenDarkTheme();

	@Query(value = """
			FROM Utilisateur
			WHERE id not in
				(SELECT DISTINCT utilisateur.id
				FROM Gif)
				""")
	List<Utilisateur> findNonContributingUsers();

	@Query(value = "FROM Utilisateur ORDER BY prenom")
	List<Utilisateur> findAllUsersSortedByPrenom();

	@Query(value = """
			SELECT nom, prenom
			FROM Utilisateur
			WHERE month(dateHeureInscription)='4'
			AND year(dateHeureInscription)='2022'
			AND email LIKE '%@hb.com'
			""")
	List<Utilisateur> findInscriptionAvrilUsers();

	@Query(value = """
			FROM Utilisateur u
			WHERE u.email LIKE :email
			AND u.motDePasse LIKE :motDePasse
			""")
	Utilisateur findUserByEmailAndMdp(@Param("email") String email, @Param("motDePasse") String motDePasse);

	@Query(value = """
			SELECT new fr.humanbooster.fx.calendrier_gif.util.NbInscrits(  month(u.dateHeureInscription), year(u.dateHeureInscription), COUNT(u) AS NbInscrits)
			FROM Utilisateur u
			GROUP BY month(u.dateHeureInscription), year(u.dateHeureInscription)
			""")
	List<NbInscrits> findNbInscrits();
}
