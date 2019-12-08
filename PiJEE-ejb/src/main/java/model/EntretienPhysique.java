package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EntretienPhysiqueId")
	private int entretienPhysiqueId;

	@Column(name="DateEntretien")
	private Date dateEntretien;

	public EntretienPhysique() {
	}

	public int getEntretienPhysiqueId() {
		return this.entretienPhysiqueId;
	}

	public void setEntretienPhysiqueId(int entretienPhysiqueId) {
		this.entretienPhysiqueId = entretienPhysiqueId;
	}

	public Date getDateEntretien() {
		return this.dateEntretien;
	}

	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

}