package fr.humanbooster.fx.calendrier_gif.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emotion")
@Getter
@Setter
@NoArgsConstructor
public class Emotion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Veuiilez saisir le nom de l'émotion")
	private String nom;
	
	@NotBlank(message = "Veuillez saisir le code de l'émotion")
	private String code;

	public Emotion(String nom, String code) {
		this();
		this.nom = nom;
		this.code = code;
	}

	@Override
	public String toString() {
		return "Emotion [id=" + id + ", nom=" + nom + ", code=" + code + "]";
	}

}