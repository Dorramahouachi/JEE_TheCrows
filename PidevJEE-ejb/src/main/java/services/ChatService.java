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

import interfaces.ChatServiceLocal;
import interfaces.ChatServiceRemote;

@Stateless
@LocalBean
public class ChatService  implements ChatServiceLocal , ChatServiceRemote {

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
		TypedQuery<Chat> query = em.createQuery("select c from Chat AS c where c.user1.userId=:id ", Chat.class);
		query.setParameter("id",id);
		p = (ArrayList<Chat>) query.getResultList()	;
		
		return p;
		
	}

	@Override
	public User getUser(String login) {
	
		return null ;
	}
	@Override
	public User getUser(int id)
	{
		TypedQuery<User> query = em
				.createQuery("select e from User e ", User.class);
		User e = null;
		e = query.getResultList().get(1);
		
			System.out.println("size oui"+query.getResultList().size());
		
		return e;
	}

	/*
	@Override
	public int addChat(Chat chat) {
		em.persist(chat);
		return chat.getChatId();

	}

	@Override
	public void removeChat(int id) {
		em.remove(em.find(Chat.class, id));
	}

	@Override
	public void updateChat(Chat chat) {
		em.merge(chat);
	}

	@Override
	public Chat findChatById(int id) {
		Chat chat = em.find(Chat.class, id);
		return chat;
	}
	
	@Override
	public List<Chat> getAllChat() {
		List<Chat> emp = em.createQuery("Select e from Chat e", Chat.class).getResultList();
		return emp;
	}
*/	
}
