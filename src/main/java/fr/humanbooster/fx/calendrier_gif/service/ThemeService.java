package fr.humanbooster.fx.calendrier_gif.service;

import java.util.List;

import fr.humanbooster.fx.calendrier_gif.business.Theme;

public interface ThemeService {

	List<Theme> recupererThemes();

	Theme recupererTheme(Long id);

}
