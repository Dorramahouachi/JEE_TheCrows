package model;

import java.io.Serializable;
import java.util.List;

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

	@OneToMany(mappedBy="evaluation", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Critere> listCriteres;
	
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

	public List<Critere> getListCriteres() {
		return listCriteres;
	}

	public void setListCriteres(List<Critere> listCriteres) {
		this.listCriteres = listCriteres;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}