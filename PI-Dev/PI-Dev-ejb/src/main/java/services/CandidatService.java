package services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.User;

@Stateless
public class CandidatService implements CandidatServiceRemote{

	@PersistenceContext(name="primary")
	EntityManager em;
	@Override
	public User getUser(int id) {
		User user = new User();
		TypedQuery<User> query = em.createQuery("select u from User u WHERE u.userId=:id", User.class); 
		query.setParameter("id", id); 
		user=query.getSingleResult();
		return user;
	}

}
