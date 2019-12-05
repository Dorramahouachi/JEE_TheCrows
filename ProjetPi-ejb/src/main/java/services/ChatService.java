package services;

import model.Chat;

import model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import interfaces.ChatServiceRemote;

@Stateless
@LocalBean
public class ChatService  implements  ChatServiceRemote {

	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public void envoyerMessage(Chat c) {
		c.setDateSend(Calendar.getInstance().getTime());
		c.setVue(0);
		
		em.persist(c);
		
	}

	@Override
	public ArrayList<Chat> getall(int id) {
		ArrayList<Chat> p ;
		TypedQuery<Chat> query = em.createQuery("select c  from Chat c where c.user1.userId=:id ", Chat.class);
		query.setParameter("id",id);

		p = (ArrayList<Chat>) query.getResultList()	;
		
		return p;
		
	}

	
	
	@Override
	public User getUser(int id)
	{
		TypedQuery<User> query = em
				.createQuery("select e from User e ", User.class);
		User e = null;
		e = query.getResultList().get(1);
		
		
		return e;
	}


	@Override
	public  ArrayList<User> getUsrs(int id)
	 {			ArrayList<User> p ;
		TypedQuery<User> query = em.createQuery("select c  from User c   ", User.class);

		p = (ArrayList<User>) query.getResultList()	;
		
		return p;
	 }
	
	}
