package fr.humanbooster.fx.calendrier_gif.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.humanbooster.fx.calendrier_gif.business.Gif;

public interface GifDao extends JpaRepository<Gif, Long> {

	@Query("""
			select size(r.gif.reactions), r.gif
			FROM Reaction r
			group by r.gif
			order by count(*) desc 
						""")
	List<Gif> findGifsWithReactions();
}
