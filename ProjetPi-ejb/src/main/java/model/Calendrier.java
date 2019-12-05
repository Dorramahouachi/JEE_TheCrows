package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Calendriers database table.
 * 
 */
@Entity
@Table(name="Calendriers")
@NamedQuery(name="Calendrier.findAll", query="SELECT c FROM Calendrier c")
public class Calendrier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CalendrierId")
	private int calendrierId;

	private String date;

	private String disponibilite;

	private double heure;

	public Calendrier() {
	}

	public int getCalendrierId() {
		return this.calendrierId;
	}

	public void setCalendrierId(int calendrierId) {
		this.calendrierId = calendrierId;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDisponibilite() {
		return this.disponibilite;
	}

	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}

	public double getHeure() {
		return this.heure;
	}

	public void setHeure(double heure) {
		this.heure = heure;
	}

}