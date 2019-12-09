package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Entreprises database table.
 * 
 */
@Entity
@Table(name="Entreprises")
@NamedQuery(name="Entrepris.findAll", query="SELECT e FROM Entrepris e")
public class Entrepris implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EntrepriseId")
	private int entrepriseId;

	@Column(name="Candidat_UserId")
	private int candidat_UserId;

	public Entrepris() {
	}

	public int getEntrepriseId() {
		return this.entrepriseId;
	}

	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	public int getCandidat_UserId() {
		return this.candidat_UserId;
	}

	public void setCandidat_UserId(int candidat_UserId) {
		this.candidat_UserId = candidat_UserId;
	}

}