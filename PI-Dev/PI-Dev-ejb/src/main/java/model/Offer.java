package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Offers database table.
 * 
 */
@Entity
@Table(name="Offers")
@NamedQuery(name="Offer.findAll", query="SELECT o FROM Offer o")
public class Offer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int offerId;

	private Object contractTypeOffer;

	private Object durationOffer;

	private Object location;

	private Object referenceOffer;

	private float salary;

	private int teamId;

	private Object titleOffer;

	//bi-directional many-to-one association to Candidature
	@OneToMany(mappedBy="offer")
	private List<Candidature> candidatures;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="offers")
	private List<User> users;

	public Offer() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public Object getContractTypeOffer() {
		return this.contractTypeOffer;
	}

	public void setContractTypeOffer(Object contractTypeOffer) {
		this.contractTypeOffer = contractTypeOffer;
	}

	public Object getDurationOffer() {
		return this.durationOffer;
	}

	public void setDurationOffer(Object durationOffer) {
		this.durationOffer = durationOffer;
	}

	public Object getLocation() {
		return this.location;
	}

	public void setLocation(Object location) {
		this.location = location;
	}

	public Object getReferenceOffer() {
		return this.referenceOffer;
	}

	public void setReferenceOffer(Object referenceOffer) {
		this.referenceOffer = referenceOffer;
	}

	public float getSalary() {
		return this.salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getTeamId() {
		return this.teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public Object getTitleOffer() {
		return this.titleOffer;
	}

	public void setTitleOffer(Object titleOffer) {
		this.titleOffer = titleOffer;
	}

	public List<Candidature> getCandidatures() {
		return this.candidatures;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

	public Candidature addCandidature(Candidature candidature) {
		getCandidatures().add(candidature);
		candidature.setOffer(this);

		return candidature;
	}

	public Candidature removeCandidature(Candidature candidature) {
		getCandidatures().remove(candidature);
		candidature.setOffer(null);

		return candidature;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}