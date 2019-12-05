package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Candidatures database table.
 * 
 */
@Entity
@Table(name="Candidatures")
@NamedQuery(name="Candidature.findAll", query="SELECT c FROM Candidature c")
public class Candidature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int candidatureId;

	private Timestamp candidatureDate;

	private String etat;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Candidature() {
	}

	public int getCandidatureId() {
		return this.candidatureId;
	}

	public void setCandidatureId(int candidatureId) {
		this.candidatureId = candidatureId;
	}

	public Timestamp getCandidatureDate() {
		return this.candidatureDate;
	}

	public void setCandidatureDate(Timestamp candidatureDate) {
		this.candidatureDate = candidatureDate;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}