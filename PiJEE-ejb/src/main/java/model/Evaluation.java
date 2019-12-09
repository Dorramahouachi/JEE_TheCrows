package model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import model.enums.EvaluationType;

@Entity
public class Evaluation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	
	private float globalNote ;
	
	private EvaluationType type;
	
	private String description; 
	
	private Date date ;
	
	@OneToMany(mappedBy = "evaluation",cascade = CascadeType.REMOVE)
	@JsonBackReference(value = "notes")
	private List<CriteriaNote> criteriaNotes ;
	
	
	
    public List<CriteriaNote> getCriteriaNotes() {
        return criteriaNotes;
    }
 
    public void setCriteriaNotes(List<CriteriaNote> criteriaNotes) {
        this.criteriaNotes = criteriaNotes;
    }
	
	
	@OneToOne
	private Userz sender;
	
	
	@OneToOne
	private Userz receiver;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JsonBackReference(value="evaluations-critere")
	private List<EvaluationCriteria> criterias;

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getGlobalNote() {
		return globalNote;
	}


	public void setGlobalNote(float globalNote) {
		this.globalNote = globalNote;
	}


	public EvaluationType getType() {
		return type;
	}


	public void setType(EvaluationType type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public List<EvaluationCriteria> getCriterias() {
		return criterias;
	}


	public void setCriterias(List<EvaluationCriteria> criterias) {
		this.criterias = criterias;
	}


	public Userz getSender() {
		return sender;
	}


	public void setSender(Userz sender) {
		this.sender = sender;
	}


	public Userz getReceiver() {
		return receiver;
	}


	public void setReceiver(Userz receiver) {
		this.receiver = receiver;
	}


	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate= formatter.format(date);  
		return strDate;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Evaluation(EvaluationType type, String description, Date date, Userz sender, Userz receiver,
			List<EvaluationCriteria> criterias, List<CriteriaNote> notes ) {
		super();
		this.type = type;
		this.description = description;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.criterias = criterias;
		this.criteriaNotes = notes;
	}
	public Evaluation(EvaluationType type, String description, Date date, Userz sender, Userz receiver,
			List<EvaluationCriteria> criterias ) {
		super();
		this.type = type;
		this.description = description;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
		this.criterias = criterias;
	}
	public Evaluation(EvaluationType type, String description, Date date, Userz sender, Userz receiver) {
		super();
		this.type = type;
		this.description = description;
		this.date = date;
		this.sender = sender;
		this.receiver = receiver;
	}


	public Evaluation() {
	}
	
	
	
	
	
	
}
