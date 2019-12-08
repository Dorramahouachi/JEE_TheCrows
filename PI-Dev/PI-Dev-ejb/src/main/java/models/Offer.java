package models;

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

	private String contractTypeOffer;

	private String durationOffer;

	private String location;

	private String referenceOffer;

	private float salary;

	private int teamId;

	private String titleOffer;

	//bi-directional many-to-one association to Candidature
	@OneToMany(mappedBy="offer")
	private List<Candidature> candidatures;

	//bi-directional many-to-one association to Commentaire
	@OneToMany(mappedBy="offer")
	private List<Commentaire> commentaires;

	public Offer() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getContractTypeOffer() {
		return this.contractTypeOffer;
	}

	public void setContractTypeOffer(String contractTypeOffer) {
		this.contractTypeOffer = contractTypeOffer;
	}

	public String getDurationOffer() {
		return this.durationOffer;
	}

	public void setDurationOffer(String durationOffer) {
		this.durationOffer = durationOffer;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReferenceOffer() {
		return this.referenceOffer;
	}

	public void setReferenceOffer(String referenceOffer) {
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

	public String getTitleOffer() {
		return this.titleOffer;
	}

	public void setTitleOffer(String titleOffer) {
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

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Commentaire addCommentaire(Commentaire commentaire) {
		getCommentaires().add(commentaire);
		commentaire.setOffer(this);

		return commentaire;
	}

	public Commentaire removeCommentaire(Commentaire commentaire) {
		getCommentaires().remove(commentaire);
		commentaire.setOffer(null);

		return commentaire;
	}

}