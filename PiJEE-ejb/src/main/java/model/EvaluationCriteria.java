package model;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EvaluationCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String criteria;
	private int note ;
	
	@OneToMany(mappedBy = "criteria", cascade = CascadeType.REMOVE)
	@JsonBackReference(value="evaluations-note")
	private List<CriteriaNote> criteriaNotes;

	
    public List<CriteriaNote> getCriteriaNotes() {
        return criteriaNotes;
    }
 
    public void setCriteriaNotes(List<CriteriaNote> criteriaNotes) {
        this.criteriaNotes = criteriaNotes;
    }
	
	
	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy="criterias")
	@JsonBackReference(value="evaluations-critere")
	private List<Evaluation> evaluations;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public EvaluationCriteria(int id, String criteria, int note, List<Evaluation> evaluations) {
		super();
		this.id = id;
		this.criteria = criteria;
		this.note = note;
		this.evaluations = evaluations;
	}

	public EvaluationCriteria(String criteria, int note) {
		this.criteria = criteria;
		this.note = note;
	}

	public EvaluationCriteria() {
	}

	@Override
	public String toString() {
		return "EvaluationCriteria [id=" + id + ", criteria=" + criteria + ", note=" + note + "]";
	}
	
	
	
	
	
	
	
	
	
}
