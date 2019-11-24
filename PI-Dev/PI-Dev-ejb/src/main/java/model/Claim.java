package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Claim database table.
 * 
 */
@Entity
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ClaimId")
	private int claimId;

	@Column(name="DateClaim")
	private Timestamp dateClaim;

	@Column(name="Description")
	private Object description;

	@Column(name="Name")
	private Object name;

	public Claim() {
	}

	public int getClaimId() {
		return this.claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public Timestamp getDateClaim() {
		return this.dateClaim;
	}

	public void setDateClaim(Timestamp dateClaim) {
		this.dateClaim = dateClaim;
	}

	public Object getDescription() {
		return this.description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

}