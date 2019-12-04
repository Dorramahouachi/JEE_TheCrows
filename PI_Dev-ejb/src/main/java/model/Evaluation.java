package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Evaluations database table.
 * 
 */
@Entity
@Table(name="Evaluations")
@NamedQuery(name="Evaluation.findAll", query="SELECT e FROM Evaluation e")
public class Evaluation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EvaluationID")
	private int evaluationID;

	@Column(name="Description")
	private String description;

	//bi-directional one-to-one association to Candidature
	@OneToOne
	@JoinColumn(name="candidatureId")
	private Candidature candidature;

	public Evaluation() {
	}

	public int getEvaluationID() {
		return this.evaluationID;
	}

	public void setEvaluationID(int evaluationID) {
		this.evaluationID = evaluationID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Candidature getCandidature() {
		return this.candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}

}