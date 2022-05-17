package fr.humanbooster.fx.calendrier_gif;

//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CalendrierGifApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalendrierGifApplication.class, args);
	}

//	/**
//	 * Cette méthode affiche en console tous les objets présents dans le onteneur
//	 * Spring
//	 * 
//	 * @param applicationContext
//	 * @return
//	 */
//	@Bean(name = "affichageDesBeans")
//	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
//		return args -> {
//			String[] noms = applicationContext.getBeanDefinitionNames();
//			for (String nom : noms) {
//				System.out.println(nom + " : " + applicationContext.getBean(nom).getClass().getSimpleName());
//			}
//		};
//	}

}
