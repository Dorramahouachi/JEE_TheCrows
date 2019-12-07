package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.User;

@Stateless
@LocalBean
public class UserService {
	@PersistenceContext(unitName = "primary")
	EntityManager em;
	public User getEmployeByEmailAndPassword(String login, String password) {
		TypedQuery<User> query = em
				.createQuery("select e from User e where e.firstName=:login AND e.password=:password", User.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		User employe = null;
		try {
			employe = query.getSingleResult();
		} catch (Exception

		e) {
			System.out.println("Erreur : " + e);
		}

		return employe;
	}
}
