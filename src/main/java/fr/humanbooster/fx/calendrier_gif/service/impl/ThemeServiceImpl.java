package fr.humanbooster.fx.calendrier_gif.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.fx.calendrier_gif.business.Theme;
import fr.humanbooster.fx.calendrier_gif.dao.ThemeDao;
import fr.humanbooster.fx.calendrier_gif.service.ThemeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService {
	
	private final ThemeDao themeDao;

	@Override
	public List<Theme> recupererThemes() {
		return themeDao.findAll();
	}
	
	@Override
	public Theme recupererTheme(Long id) {
		return themeDao.findById(id).orElse(null);
	}

}
