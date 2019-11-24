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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QuestionId")
	private int questionId;

	@Column(name="NoteQuestion")
	private int noteQuestion;

	@Column(name="Questions")
	private Object questions;

	@Column(name="ReponseCorrect")
	private Object reponseCorrect;

	@Column(name="ReponseIncorrect1")
	private Object reponseIncorrect1;

	@Column(name="ReponseIncorrect2")
	private Object reponseIncorrect2;

	//bi-directional many-to-one association to Entretien
	@OneToMany(mappedBy="question")
	private List<Entretien> entretiens;

	//bi-directional many-to-one association to Entretien
	@ManyToOne
	@JoinColumn(name="EntretienEnLigne_EntretienId")
	private Entretien entretien1;

	//bi-directional many-to-one association to Entretien
	@ManyToOne
	@JoinColumn(name="EntretienEnLigne_EntretienId1")
	private Entretien entretien2;

	public Question() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getNoteQuestion() {
		return this.noteQuestion;
	}

	public void setNoteQuestion(int noteQuestion) {
		this.noteQuestion = noteQuestion;
	}

	public Object getQuestions() {
		return this.questions;
	}

	public void setQuestions(Object questions) {
		this.questions = questions;
	}

	public Object getReponseCorrect() {
		return this.reponseCorrect;
	}

	public void setReponseCorrect(Object reponseCorrect) {
		this.reponseCorrect = reponseCorrect;
	}

	public Object getReponseIncorrect1() {
		return this.reponseIncorrect1;
	}

	public void setReponseIncorrect1(Object reponseIncorrect1) {
		this.reponseIncorrect1 = reponseIncorrect1;
	}

	public Object getReponseIncorrect2() {
		return this.reponseIncorrect2;
	}

	public void setReponseIncorrect2(Object reponseIncorrect2) {
		this.reponseIncorrect2 = reponseIncorrect2;
	}

	public List<Entretien> getEntretiens() {
		return this.entretiens;
	}

	public void setEntretiens(List<Entretien> entretiens) {
		this.entretiens = entretiens;
	}

	public Entretien addEntretien(Entretien entretien) {
		getEntretiens().add(entretien);
		entretien.setQuestion(this);

		return entretien;
	}

	public Entretien removeEntretien(Entretien entretien) {
		getEntretiens().remove(entretien);
		entretien.setQuestion(null);

		return entretien;
	}

	public Entretien getEntretien1() {
		return this.entretien1;
	}

	public void setEntretien1(Entretien entretien1) {
		this.entretien1 = entretien1;
	}

	public Entretien getEntretien2() {
		return this.entretien2;
	}

	public void setEntretien2(Entretien entretien2) {
		this.entretien2 = entretien2;
	}

}