package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Userz;
import services.interfaces.UserServiceRemote;



@Stateless
@LocalBean
public class UserService implements UserServiceRemote {

	@PersistenceContext
	EntityManager em;

	
	
	
	public int addUser(Userz User) {
		em.persist(User);
		return User.getId();
	}

	@Override
	public void updateUser(Userz User) { 
		
	}
	
	@Override
	public Userz getUserByEmailAndPassword(String email, String password) {
		Userz employe; 
		System.out.println("logggggggggggiiiiiiiiiiiiiiin " + email);
		TypedQuery<Userz> query = em.createQuery("SELECT e FROM Userz e WHERE e.email = :email and e.password = :password ", Userz.class) 
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
	public List<Userz> getAllUsers() {
		List<Userz> users = em.createQuery("SELECT u FROM Userz u",Userz.class).getResultList();
		return users;
	}

	@Override
	public List<String> getAllUserNames() {
		List<String> names = new ArrayList<>();
		for(Userz u : getAllUsers()) {
			names.add(u.getFirstname() + " " + u.getLastname());
		}
		return names;
	}

	@Override
	public Userz getUserById(int id) {
		Userz user = null;
		try {
			user = em.find(Userz.class, id);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<Userz> getUsesDistinctFromLoggedUser(int id) {
		List<Userz> users = em.createQuery("SELECT u FROM Userz u WHERE u.id = :id",Userz.class)
				.setParameter("id", id)
				.getResultList();
		return users;
	}
	
}