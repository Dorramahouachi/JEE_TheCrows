package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Criteres database table.
 * 
 */
@Entity
@Table(name="Criteres")
@NamedQuery(name="Critere.findAll", query="SELECT c FROM Critere c")
public class Critere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CritereID")
	private int critereID;

	@Column(name="CritereName")
	private String critereName;

	@Column(name="Type")
	private CritereType type;

	//bi-directional many-to-one association to Evaluation
	@ManyToOne
	@JoinColumn(name="EvaluationID")
	private Evaluation evaluation;

	public Critere() {
	}

	public int getCritereID() {
		return this.critereID;
	}

	public void setCritereID(int critereID) {
		this.critereID = critereID;
	}

	public String getCritereName() {
		return this.critereName;
	}

	public void setCritereName(String critereName) {
		this.critereName = critereName;
	}

	public CritereType getType() {
		return this.type;
	}

	public void setType(CritereType type) {
		this.type = type;
	}

	public Evaluation getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

}