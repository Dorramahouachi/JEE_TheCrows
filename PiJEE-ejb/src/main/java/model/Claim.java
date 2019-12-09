package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Claim implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String claimSubject;
	
	@OneToOne
	private Evaluation evaluation;
	
	@OneToOne
	private Userz employee;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClaimSubject() {
		return claimSubject;
	}

	public void setClaimSubject(String claimSubject) {
		this.claimSubject = claimSubject;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public Userz getEmployee() {
		return employee;
	}

	public void setEmployee(Userz employee) {
		this.employee = employee;
	}
	
	
	
	
}
