package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "EVALUATION_CRITERIA_NOTE")
public class CriteriaNote {

	
   

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private EvaluationCriteria criteria;
	
	@ManyToOne
	private Evaluation evaluation;

	private int note ;
	
	
	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public EvaluationCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(EvaluationCriteria criteria) {
		this.criteria = criteria;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public CriteriaNote(int note, EvaluationCriteria criteria, Evaluation evaluation) {
		super();
		this.note = note;
		this.criteria = criteria;
		this.evaluation = evaluation;
	}

	public CriteriaNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
	
	
	
}
