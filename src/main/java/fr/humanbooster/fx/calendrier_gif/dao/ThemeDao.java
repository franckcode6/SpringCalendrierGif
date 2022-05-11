package fr.humanbooster.fx.calendrier_gif.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.humanbooster.fx.calendrier_gif.business.Theme;

public interface ThemeDao extends JpaRepository<Theme, Long> {

}
