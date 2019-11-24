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

	private Object actualPost;

	private Timestamp contactDate;

	private Object contactId1;

	private Object lastName;

	@Column(name="Name")
	private Object name;

	private Object pic;

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

	public Object getActualPost() {
		return this.actualPost;
	}

	public void setActualPost(Object actualPost) {
		this.actualPost = actualPost;
	}

	public Timestamp getContactDate() {
		return this.contactDate;
	}

	public void setContactDate(Timestamp contactDate) {
		this.contactDate = contactDate;
	}

	public Object getContactId1() {
		return this.contactId1;
	}

	public void setContactId1(Object contactId1) {
		this.contactId1 = contactId1;
	}

	public Object getLastName() {
		return this.lastName;
	}

	public void setLastName(Object lastName) {
		this.lastName = lastName;
	}

	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public Object getPic() {
		return this.pic;
	}

	public void setPic(Object pic) {
		this.pic = pic;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}