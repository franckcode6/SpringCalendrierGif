package fr.humanbooster.fx.calendrier_gif.automatisme;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import fr.humanbooster.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

//Spring va instancier cette classe au lancement de l'application
//Spring va ajouter cette instance dans son conteneur
//@Component
@AllArgsConstructor
public class JourAutomatisme {

	private final JourService jourService;
	
	@Scheduled(cron="0 */5 * * * *")
	public void ajouterJour() {
		System.out.println(jourService.ajouterJour());
	}
}
