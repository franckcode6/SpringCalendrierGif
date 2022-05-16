package fr.humanbooster.fx.calendrier_gif.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.humanbooster.fx.calendrier_gif.business.Jour;

public interface JourService {

	List<Jour> recupererJours();

	Page<Jour> recupererJours(Pageable pageable);

}
