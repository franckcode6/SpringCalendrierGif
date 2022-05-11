package fr.humanbooster.fx.calendrier_gif.dao;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.calendrier_gif.business.Jour;

public interface JourDao extends JpaRepository<Jour, LocalDate> {

}
