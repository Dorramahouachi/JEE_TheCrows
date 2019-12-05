package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the subscribes database table.
 * 
 */
@Entity
@Table(name="subscribes")
@NamedQuery(name="Subscribe.findAll", query="SELECT s FROM Subscribe s")
public class Subscribe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subscribeId;

	private Timestamp subscribeDate;

	//bi-directional many-to-one association to Entrepris
	@ManyToOne
	@JoinColumn(name="EntrepriseId")
	private Entrepris entrepris;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Subscribe() {
	}

	public int getSubscribeId() {
		return this.subscribeId;
	}

	public void setSubscribeId(int subscribeId) {
		this.subscribeId = subscribeId;
	}

	public Timestamp getSubscribeDate() {
		return this.subscribeDate;
	}

	public void setSubscribeDate(Timestamp subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public Entrepris getEntrepris() {
		return this.entrepris;
	}

	public void setEntrepris(Entrepris entrepris) {
		this.entrepris = entrepris;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}