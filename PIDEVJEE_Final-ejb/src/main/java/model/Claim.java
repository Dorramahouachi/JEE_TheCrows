package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the Claims database table.
 * 
 */
@Entity
@Table(name="Claims")
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	public Claim(  String name,Date dateClaim, String description) {
		super();
		
		this.dateClaim = dateClaim;
		this.description = description;
		this.name = name;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ClaimId")
	private int claimId;

	
	@Column(name="DateClaim")
	private Date dateClaim;

	@Column(name="Description")
	private String description;

	@Column(name="Name")
	private String name;
	
	@Column(name="User_userId")
	private int userId;
	
	
	
	
	
	

	public Claim() {
	}

	public Claim(String name2, Date dateClaim2, String description2, int i) {
		// TODO Auto-generated constructor stub
	}

	public Claim(String name2, String dateClaim2, String description2, int i) {
		// TODO Auto-generated constructor stub
	}



	public int getClaimId() {
		return this.claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}





	/*public String getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(String dateClaim) {
		this.dateClaim = dateClaim;
	}
*/
	public int getUserId() {
		return userId;
	}

	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}