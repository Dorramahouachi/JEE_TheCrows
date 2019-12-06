package tn.esprit.pidev.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.User;
import tn.esprit.pidev.services.interfaces.UserServiceRemote;

@Stateless
@LocalBean
public class UserService implements UserServiceRemote {

	@PersistenceContext
	EntityManager em;

	
	
	
	public int addUser(User User) {
		em.persist(User);
		return User.getUserId();
	}

	@Override
	public void updateUser(User User) { 
		
	}
	
	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		User employe; 
		System.out.println("logggggggggggiiiiiiiiiiiiiiin " + email);
		TypedQuery<User> query = em.createQuery("SELECT e FROM User e WHERE e.email = :email and e.password = :password ", User.class) 
				.setParameter("email", email) 
				.setParameter("password", password); 
		
		try {
			employe = query.getSingleResult(); 
			return employe;
		}
		catch (NoResultException e) {
			System.out.println(e);
		}
		return null;
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = em.createQuery("SELECT u FROM User u",User.class).getResultList();
		return users;
	}

	@Override
	public List<String> getAllUserNames() {
		List<String> names = new ArrayList<>();
		for(User u : getAllUsers()) {
			names.add(u.getUsername());
		}
		return names;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		try {
			user = em.find(User.class, id);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<User> getUsesDistinctFromLoggedUser(int id) {
		List<User> users = em.createQuery("SELECT u FROM User u WHERE u.id != :id",User.class)
				.setParameter("id", id)
				.getResultList();
		return users;
	}
	
}