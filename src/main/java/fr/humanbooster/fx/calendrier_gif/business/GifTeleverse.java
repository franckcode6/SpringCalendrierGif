package fr.humanbooster.fx.calendrier_gif.business;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GifTeleverse extends Gif {

	@Column(name = "nom_fichier_original")
	protected String nomFichierOriginal;

	public GifTeleverse(String nomFichierOriginal, String legende, Jour jour, Utilisateur utilisateur) {
		super(legende, jour, utilisateur);
		this.nomFichierOriginal = nomFichierOriginal;
	}

	@Override
	public String toString() {
		return "GifTeleverse [nom=" + nomFichierOriginal + ", getLegende()=" + getLegende() + ", getReaction()="
				+ getReactions() + ", getJour()=" + getJour().getDate() + "]";
	}

}