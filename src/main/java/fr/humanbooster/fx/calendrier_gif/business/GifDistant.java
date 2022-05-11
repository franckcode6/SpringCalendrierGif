package fr.humanbooster.fx.calendrier_gif.business;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GifDistant extends Gif {

	@NotBlank(message = "Merci de saisir une URL")
	@URL
	private String url;

	public GifDistant(String url, String legende, Jour jour, Utilisateur utilisateur) {
		super(legende, jour, utilisateur);
		this.url = url;
	}

	@Override
	public String toString() {
		return "GifDistant [url=" + url + ", getLegende()=" + getLegende() + ", getReaction()=" + getReactions()
				+ ", getJour()=" + getJour().getDate() + "]";
	}

}