package fr.humanbooster.fx.calendrier_gif.business;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reaction")
@Getter
@Setter
public class Reaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "date_heure")
	private LocalDateTime dateHeure;
	
	@ManyToOne
	private Gif gif;
	
	@ManyToOne
	private Emotion emotion;
	
	@ManyToOne
	private Utilisateur utilisateur;

	public Reaction() {
		dateHeure = LocalDateTime.now();
	}

	public Reaction(Gif gif, Emotion emotion, Utilisateur utilisateur) {
		this();
		this.gif = gif;
		this.emotion = emotion;
		this.utilisateur = utilisateur;
		gif.getReactions().add(this);
	}

	@Override
	public String toString() {
		return "Reaction [id=" + id + ", dateHeure=" + dateHeure + ", gif=" + gif + ", emotion=" + emotion
				+ ", utilisateur=" + utilisateur + "]";
	}

}