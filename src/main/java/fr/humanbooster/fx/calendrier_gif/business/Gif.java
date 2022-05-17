package fr.humanbooster.fx.calendrier_gif.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "gif")
@Setter
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Gif {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "date_heure_ajout")
	protected LocalDateTime dateHeureAjout;

	protected String legende;

	@OneToMany(mappedBy = "gif")
	@ToString.Exclude
	private List<Reaction> reactions;

	@NotNull
	@OneToOne
	@JoinColumn(unique = true)
	protected Jour jour;

	@ManyToOne
	private Utilisateur utilisateur;

	public Gif() {
		dateHeureAjout = LocalDateTime.now();
	}

	public Gif(String legende, Jour jour, Utilisateur utilisateur) {
		this();
		this.legende = legende;
		this.jour = jour;
		this.utilisateur = utilisateur;
		// On affecte l'objet en cours de creation au jour donné en paramètre
//		jour.setGif(this);
//		utilisateur.getGifs().add(this);
	}

	@Override
	public String toString() {
		return "Gif [id=" + id + ", dateHeureAjout=" + dateHeureAjout + ", legende=" + legende + ", reactions="
				+ reactions + ", jour=" + jour.getDate() + ", utilisateur=" + utilisateur + "]";
	}

}