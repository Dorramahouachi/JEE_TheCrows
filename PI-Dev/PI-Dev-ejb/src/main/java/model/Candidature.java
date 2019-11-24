package model;

import java.io.Serializable;
import javax.persistence.*;


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

	private Object etat;

	//bi-directional many-to-one association to Offer
	@ManyToOne
	@JoinColumn(name="OfferId")
	private Offer offer;

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

	public Object getEtat() {
		return this.etat;
	}

	public void setEtat(Object etat) {
		this.etat = etat;
	}

	public Offer getOffer() {
		return this.offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}