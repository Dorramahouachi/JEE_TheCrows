package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Contacts database table.
 * 
 */
@Entity
@Table(name="Contacts")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ContactId")
	private int contactId;

	private Timestamp contactDate;

	//private Object contactId1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Contact() {
	}

	public int getContactId() {
		return this.contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public Timestamp getContactDate() {
		return this.contactDate;
	}

	public void setContactDate(Timestamp contactDate) {
		this.contactDate = contactDate;
	}

	/*PUBLIC OBJECT GETCONTACTID1() {
		RETURN THIS.CONTACTID1;
	}

	PUBLIC VOID SETCONTACTID1(OBJECT CONTACTID1) {
		THIS.CONTACTID1 = CONTACTID1;
	}*/

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}