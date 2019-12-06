package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import tn.esprit.pidev.enums.Post;
import tn.esprit.pidev.enums.Role;

@Entity
public class UserTwo implements Serializable  {


	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String email;
	
	private String password;
	
	private String phoneNumber;
	
	private Role role;
	
	private Post post;
	
	
	@OneToMany(mappedBy="sender")
	private List<Evaluation> evaluationsSent;
	
	
	@OneToMany(mappedBy="receiver")
	private List<Evaluation> evaluationsReceived;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public UserTwo() {
		
	}

	public List<Evaluation> getEvaluationsSent() {
		return evaluationsSent;
	}

	public void setEvaluationsSent(List<Evaluation> evaluationsSent) {
		this.evaluationsSent = evaluationsSent;
	}

	public List<Evaluation> getEvaluationsReceived() {
		return evaluationsReceived;
	}

	public void setEvaluationsReceived(List<Evaluation> evaluationsReceived) {
		this.evaluationsReceived = evaluationsReceived;
	}

	public UserTwo(int id, String firstname, String lastname, String email, String password, String phoneNumber, Role role,
			Post post, List<Evaluation> evaluationsSent, List<Evaluation> evaluationsReceived) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.post = post;
		this.evaluationsSent = evaluationsSent;
		this.evaluationsReceived = evaluationsReceived;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
}
