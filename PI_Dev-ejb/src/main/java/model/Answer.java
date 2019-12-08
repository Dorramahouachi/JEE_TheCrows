package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Answers database table.
 * 
 */
@Entity
@Table(name="Answers")
@NamedQuery(name="Answer.findAll", query="SELECT a FROM Answer a")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AnswerID")
	private int answerID;

	@Column(name="Content")
	private String content;

	@Column(name="Correct")
	private boolean correct;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="QuestionID")
	private Question question;

	public Answer() {
	}

	public int getAnswerID() {
		return this.answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean getCorrect() {
		return this.correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}