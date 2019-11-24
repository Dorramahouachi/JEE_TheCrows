package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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
	@Column(name="CalendrierId")
	private int calendrierId;

	@Column(name="End")
	private Timestamp end;

	@Column(name="IsFullDay")
	private int isFullDay;

	@Column(name="Start")
	private Timestamp start;

	@Column(name="ThemeColor")
	private String themeColor;

	public Calendrier() {
	}

	public int getCalendrierId() {
		return this.calendrierId;
	}

	public void setCalendrierId(int calendrierId) {
		this.calendrierId = calendrierId;
	}

	public Timestamp getEnd() {
		return this.end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public int getIsFullDay() {
		return this.isFullDay;
	}

	public void setIsFullDay(int isFullDay) {
		this.isFullDay = isFullDay;
	}

	public Timestamp getStart() {
		return this.start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public String getThemeColor() {
		return this.themeColor;
	}

	public void setThemeColor(String themeColor) {
		this.themeColor = themeColor;
	}

}