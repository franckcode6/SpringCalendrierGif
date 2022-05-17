package fr.humanbooster.fx.calendrier_gif.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fr.humanbooster.fx.calendrier_gif.business.Jour;
import fr.humanbooster.fx.calendrier_gif.dao.JourDao;
import fr.humanbooster.fx.calendrier_gif.service.JourService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JourServiceImpl implements JourService {
	
	private final JourDao jourDao;

	@Override
	public List<Jour> recupererJours() {
		return jourDao.findAll();
	}
	
	@Override
    public Page<Jour> recupererJours(Pageable pageable) {
        return jourDao.findAll(pageable);
    }

	@Override
	public Jour ajouterJour() {
		LocalDate date = jourDao.findFirstByOrderByDateDesc().getDate();
		Jour jour = jourDao.save(new Jour(date.plusDays(1)));
		return jour;
	}

}
