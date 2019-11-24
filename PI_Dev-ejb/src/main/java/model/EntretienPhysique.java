package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the EntretienPhysiques database table.
 * 
 */
@Entity
@Table(name="EntretienPhysiques")
@NamedQuery(name="EntretienPhysique.findAll", query="SELECT e FROM EntretienPhysique e")
public class EntretienPhysique implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EntretienPhysiqueId")
	private int entretienPhysiqueId;

	private int cadidature;

	@Column(name="DateEntretien")
	private Timestamp dateEntretien;

	public EntretienPhysique() {
	}

	public int getEntretienPhysiqueId() {
		return this.entretienPhysiqueId;
	}

	public void setEntretienPhysiqueId(int entretienPhysiqueId) {
		this.entretienPhysiqueId = entretienPhysiqueId;
	}

	public int getCadidature() {
		return this.cadidature;
	}

	public void setCadidature(int cadidature) {
		this.cadidature = cadidature;
	}

	public Timestamp getDateEntretien() {
		return this.dateEntretien;
	}

	public void setDateEntretien(Timestamp dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

}