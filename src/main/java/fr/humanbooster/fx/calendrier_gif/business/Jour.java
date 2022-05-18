package fr.humanbooster.fx.calendrier_gif.business;

import java.time.LocalDate;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "jour")
@Setter
@Getter
public class Jour {

	@Id
	private LocalDate date;

	@Column(name = "nb_points")
	private int nbPoints;

	@JsonIgnore
	@OneToOne(mappedBy = "jour")
	@ToString.Exclude
	private Gif gif;

	private static Random random = new Random();

	public Jour() {
		date = LocalDate.now();
		nbPoints = 20 + random.nextInt(31);
	}

	public Jour(LocalDate date) {
		this();
		this.date = date;
	}

	public Jour(int nbPoints, Gif gif) {
		this();
		this.nbPoints = nbPoints;
		this.gif = gif;
	}

	public String toString() {
		return date.getDayOfMonth() + "/" + date.getMonthValue();
	}

}