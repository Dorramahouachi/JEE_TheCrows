package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Entreprises database table.
 * 
 */
@Entity
@Table(name="Entreprises")
@NamedQuery(name="Entrepris.findAll", query="SELECT e FROM Entrepris e")
public class Entrepris implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EntrepriseId")
	private int entrepriseId;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Candidat_UserId")
	private Userz user;

	//bi-directional many-to-one association to Subscribe
	@OneToMany(mappedBy="entrepris")
	private List<Subscribe> subscribes;

	public Entrepris() {
	}

	public int getEntrepriseId() {
		return this.entrepriseId;
	}

	public void setEntrepriseId(int entrepriseId) {
		this.entrepriseId = entrepriseId;
	}

	public Userz getUser() {
		return this.user;
	}

	public void setUser(Userz user) {
		this.user = user;
	}

	public List<Subscribe> getSubscribes() {
		return this.subscribes;
	}

	public void setSubscribes(List<Subscribe> subscribes) {
		this.subscribes = subscribes;
	}

	public Subscribe addSubscribe(Subscribe subscribe) {
		getSubscribes().add(subscribe);
		subscribe.setEntrepris(this);

		return subscribe;
	}

	public Subscribe removeSubscribe(Subscribe subscribe) {
		getSubscribes().remove(subscribe);
		subscribe.setEntrepris(null);

		return subscribe;
	}

}