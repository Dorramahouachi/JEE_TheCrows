package models;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;


/**
 * The persistent class for the Entretiens database table.
 * 
 */
@Entity
@Table(name="Entretiens")
@NamedQuery(name="Entretien.findAll", query="SELECT e FROM Entretien e")
public class Entretien implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EntretienId")
	private int entretienId;

	@Column(name="DateEntretien")
	private Date dateEntretien;

	@Column(name="Discriminator")
	private String discriminator;

	@Column(name="EntretienEnLigneId")
	private int entretienEnLigneId;

	@Column(name="EntretienPhysiqueId")
	private int entretienPhysiqueId;

	private int noteEntretien;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="QuestionId")
	private Question question;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="entretien1")
	private List<Question> questions1;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="entretien2")
	private List<Question> questions2;

	public Entretien() {
	}

	public int getEntretienId() {
		return this.entretienId;
	}

	public void setEntretienId(int entretienId) {
		this.entretienId = entretienId;
	}

	public Date getDateEntretien() {
		return this.dateEntretien;
	}

	public void setDateEntretien(Date dateEntretien) {
		this.dateEntretien = dateEntretien;
	}

	public String getDiscriminator() {
		return this.discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}

	public int getEntretienEnLigneId() {
		return this.entretienEnLigneId;
	}

	public void setEntretienEnLigneId(int entretienEnLigneId) {
		this.entretienEnLigneId = entretienEnLigneId;
	}

	public int getEntretienPhysiqueId() {
		return this.entretienPhysiqueId;
	}

	public void setEntretienPhysiqueId(int entretienPhysiqueId) {
		this.entretienPhysiqueId = entretienPhysiqueId;
	}

	public int getNoteEntretien() {
		return this.noteEntretien;
	}

	public void setNoteEntretien(int noteEntretien) {
		this.noteEntretien = noteEntretien;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Question> getQuestions1() {
		return this.questions1;
	}

	public void setQuestions1(List<Question> questions1) {
		this.questions1 = questions1;
	}

	public Question addQuestions1(Question questions1) {
		getQuestions1().add(questions1);
		questions1.setEntretien1(this);

		return questions1;
	}

	public Question removeQuestions1(Question questions1) {
		getQuestions1().remove(questions1);
		questions1.setEntretien1(null);

		return questions1;
	}

	public List<Question> getQuestions2() {
		return this.questions2;
	}

	public void setQuestions2(List<Question> questions2) {
		this.questions2 = questions2;
	}

	public Question addQuestions2(Question questions2) {
		getQuestions2().add(questions2);
		questions2.setEntretien2(this);

		return questions2;
	}

	public Question removeQuestions2(Question questions2) {
		getQuestions2().remove(questions2);
		questions2.setEntretien2(null);

		return questions2;
	}

}