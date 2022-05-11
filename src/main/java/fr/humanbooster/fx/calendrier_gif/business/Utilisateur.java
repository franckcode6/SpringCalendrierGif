package fr.humanbooster.fx.calendrier_gif.business;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "utilisateur")
@Getter
@Setter
public class Utilisateur {

	private final static int NB_POINTS_INITIAL = 500;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Veuillez saisir votre nom")
	private String nom;

	@NotBlank(message = "Veuillez saisir votre prénom")
	private String prenom;

	@NotBlank(message = "Veuillez saisir votre email")
	private String email;

	@Column(name = "mot_de_passe")
	private String motDePasse;

	@Column(name = "nb_points")
	private int nbPoints;

	@Column(name = "date_heure_inscription")
	private LocalDateTime dateHeureInscription;

	@NotNull(message = "Veuillez sélectionner un thème")
	@ManyToOne
	@JoinColumn(name = "theme_id")
	private Theme theme;

	@OneToMany(mappedBy = "utilisateur")
	@ToString.Exclude
	private List<Gif> gifs;

	@OneToMany(mappedBy = "utilisateur")
	@ToString.Exclude
	private List<Reaction> reactions;

	public Utilisateur() {
		this.nbPoints = NB_POINTS_INITIAL;
		dateHeureInscription = LocalDateTime.now();
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, Theme theme) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", motDePasse="
				+ motDePasse + ", nbPoints=" + nbPoints + ", dateHeureInscription=" + dateHeureInscription + ", theme="
				+ theme + ", gifs=" + gifs + "]";
	}

}