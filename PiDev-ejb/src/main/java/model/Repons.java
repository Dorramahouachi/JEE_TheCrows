package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Reponses database table.
 * 
 */
@Entity
@Table(name="Reponses")
@NamedQuery(name="Repons.findAll", query="SELECT r FROM Repons r")
public class Repons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReponseID")
	private int reponseID;

	@Column(name="AnswerQ")
	private Object answerQ;

	private boolean isCorrect;

	@Column(name="ReponseText")
	private Object reponseText;

	//bi-directional many-to-one association to Question


	public Repons() {
	}

	public int getReponseID() {
		return this.reponseID;
	}

	public void setReponseID(int reponseID) {
		this.reponseID = reponseID;
	}

	public Object getAnswerQ() {
		return this.answerQ;
	}

	public void setAnswerQ(Object answerQ) {
		this.answerQ = answerQ;
	}

	public boolean getIsCorrect() {
		return this.isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Object getReponseText() {
		return this.reponseText;
	}

	public void setReponseText(Object reponseText) {
		this.reponseText = reponseText;
	}



}