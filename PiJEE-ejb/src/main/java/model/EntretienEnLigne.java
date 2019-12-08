package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EntretienEnLignes database table.
 * 
 */
@Entity
@Table(name="EntretienEnLignes")
@NamedQuery(name="EntretienEnLigne.findAll", query="SELECT e FROM EntretienEnLigne e")
public class EntretienEnLigne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EntretienEnLigneId")
	private int entretienEnLigneId;

	private int noteEntretien;

	public EntretienEnLigne() {
	}

	public int getEntretienEnLigneId() {
		return this.entretienEnLigneId;
	}

	public void setEntretienEnLigneId(int entretienEnLigneId) {
		this.entretienEnLigneId = entretienEnLigneId;
	}

	public int getNoteEntretien() {
		return this.noteEntretien;
	}

	public void setNoteEntretien(int noteEntretien) {
		this.noteEntretien = noteEntretien;
	}

}