package fr.humanbooster.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.humanbooster.fx.calendrier_gif.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

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
	
	@Query(value="""
			FROM Utilisateur u
			WHERE u.email LIKE :email
			AND u.motDePasse LIKE :motDePasse
			""")
	Utilisateur findUserByEmailAndMdp(@Param("email") String email, @Param("motDePasse") String motDePasse);
}
