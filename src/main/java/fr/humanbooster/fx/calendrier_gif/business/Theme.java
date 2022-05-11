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
@Table(name = "theme")
@Getter
@Setter
@NoArgsConstructor
public class Theme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Veuillez saisir un nom de thème")
	private String nom;

	public Theme(String nom) {
		this();
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", nom=" + nom + "]";
	}

}