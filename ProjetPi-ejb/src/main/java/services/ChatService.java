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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import interfaces.ChatServiceRemote;

@Stateless
@LocalBean
public class ChatService  implements  ChatServiceRemote {

	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public String envoyerMessage(Chat c) {
		
		
		TypedQuery<String> query = em.createQuery("select b.word from Word b where b.type=:type",String.class);
		query.setParameter("type","bad");
		 List<String>ls=new ArrayList<>();
		
		 ls=query.getResultList();
		 System.out.println(ls);
		 String message = c.getContenu();
		 String[] splited = message.split("\\s+");
		 Boolean b =false;
		 for (int x=0; x<splited.length; x++){
             for (int i=0;i<ls.size();i++){
                 if (ls.get(i).equals(splited[x])){
                 b=true;
                 break;
                 }}}
		 if (b==false){
				c.setDateSend(Calendar.getInstance().getTime());
				c.setVue(0);
				
				em.persist(c);
			 return "ajout avec sucées";
			 }
		 else
		 {
			 return("refus");}
		
		
	
		
	}

	@Override
	public ArrayList<Chat> getall(int id, int vue) { 
		ArrayList<Chat> p ;
		TypedQuery<Chat> query = 
				em.createQuery("select  c  from Chat c  where c.user2.userId=:id and c.vue =:vue  order by c.dateSend desc ", Chat.class);
		query.setParameter("id",id);
		query.setParameter("vue",vue);

		p = (ArrayList<Chat>) query.getResultList()	;
		
		return p;
		
	}
	@Override
	public ArrayList<Chat> getDisc(int id) {
		ArrayList<Chat> p ;
		TypedQuery<Chat> query = em.createQuery("select c  from Chat c where c.user1.userId=:id", Chat.class);
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

	@Override
	public void deleteChatId(int id) {
		Query query = em.createQuery("delete from Chat c where c.chatId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		System.out.println("iddd "+id);
	}
	public void deleteChatId1(int id)
	{Chat c=em.find(Chat.class, id);
	
		em.remove(c);}
	

	@Override
	public void updateChat(Chat e) {
		em.merge(e);
		
	}
	@Override
	public  ArrayList<Chat> getchat(int idR, int idS){
		 
		ArrayList<Chat> p ;
		TypedQuery<Chat> query = em.createQuery("select c  from Chat c where c.user1.userId=:idR and c.user2.userId=:idS ", Chat.class);
		query.setParameter("idR",idR);
		query.setParameter("idS",idS);
		p = (ArrayList<Chat>) query.getResultList()	;
		System.out.println("chatsss");
		System.out.println(p);
		System.out.println(idR);
		System.out.println(idS);

		return p;
	 }

	}
