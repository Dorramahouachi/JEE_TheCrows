package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Questions database table.
 * 
 */
@Entity
@Table(name="Questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QuestionID")
	private int questionID;

	@Column(name="Content")
	private String content;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="question")
	private List<Answer> answers;

	public Question() {
	}

	public int getQuestionID() {
		return this.questionID;
	}

	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setQuestion(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setQuestion(null);

		return answer;
	}

}