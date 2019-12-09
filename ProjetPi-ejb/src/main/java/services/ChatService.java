package services;

import model.Chat;

import model.User;
import model.Word;

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
public class ChatService implements ChatServiceRemote {

	@PersistenceContext(unitName = "primary")
	EntityManager em;

	@Override
	public String envoyerMessage(Chat c) {

		TypedQuery<String> query = em.createQuery("select b.word from Word b where b.type=:type", String.class);
		query.setParameter("type", "bad");
		List<String> ls = new ArrayList<>();

		ls = query.getResultList();
		System.out.println(ls);
		String message = c.getContenu();
		String[] splited = message.split("\\s+");
		Boolean b = false;
		for (int x = 0; x < splited.length; x++) {
			for (int i = 0; i < ls.size(); i++) {
				if (ls.get(i).equals(splited[x])) {
					b = true;
					break;
				}
			}
		}
		if (b == false) {
			c.setDateSend(Calendar.getInstance().getTime());
			c.setVue(0);

			em.persist(c);
			return "ajout avec sucées";
		} else {
			return ("refus");
		}

	}

	@Override
	public ArrayList<Chat> getall(int id, int vue) {
		ArrayList<Chat> p;
		TypedQuery<Chat> query = em.createQuery(
				"select  c  from Chat c  where c.user1.userId=:id and c.vue =:vue  order by c.dateSend desc ",
				Chat.class);
		query.setParameter("id", id);
		query.setParameter("vue", vue);

		p = (ArrayList<Chat>) query.getResultList();

		return p;

	}

	@Override
	public ArrayList<Chat> getDisc(int id) {
		ArrayList<Chat> p;
		TypedQuery<Chat> query = em.createQuery("select c  from Chat c where c.user1.userId=:id", Chat.class);
		query.setParameter("id", id);

		p = (ArrayList<Chat>) query.getResultList();

		return p;

	}

	@Override
	public User getUser(int id) {
		ArrayList<User> p;

		TypedQuery<User> query = em.createQuery("select e from User e  where e.userId=:id", User.class);
		query.setParameter("id", id);

		User e = null;
		p = (ArrayList<User>)query.getResultList();
		e=p.get(0);
		e.toString();
		return e;
	}

	@Override
	public ArrayList<User> getUsrs(int id) {
		ArrayList<User> p;
		TypedQuery<User> query = em.createQuery("select c  from User c   ", User.class);

		p = (ArrayList<User>) query.getResultList();

		return p;
	}

	@Override
	public void deleteChatId(int id) {
		Query query = em.createQuery("delete from Chat c where c.chatId=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		System.out.println("iddd " + id);
	}

	public void deleteChatId1(int id) {
		Chat c = em.find(Chat.class, id);

		em.remove(c);
	}

	@Override
	public void updateChat(Chat e) {
		Chat x = new Chat();
		x = em.find(Chat.class, e.getChatId());
		x.setContenu(e.getContenu());
		em.merge(x);
		System.out.println("contenu" + e.getContenu());

	}

	@Override
	public ArrayList<Chat> getchat(int idR, int idS) {

		ArrayList<Chat> p;
		TypedQuery<Chat> query = em.createQuery(
				"select c  from Chat c where ((c.user1.userId=:idR and c.user2.userId=:idS) or ( c.user1.userId=:idS and c.user2.userId=:idR))",
				Chat.class);
		query.setParameter("idR", idR);
		query.setParameter("idS", idS);
		p = (ArrayList<Chat>) query.getResultList();
		System.out.println("chatsss");
		System.out.println(p);
		System.out.println(idR);
		System.out.println(idS);

		return p;
	}

	@Override
	public void upVue(int id) {
		Chat x = new Chat();
		x = em.find(Chat.class, id);
		x.setVue(1);
		em.merge(x);

	}

	@Override
	public ArrayList<Word> getProp(int ids, int idr) {
		// je recupere le message
		TypedQuery<String> query = em.createQuery(
				"select  c.contenu from Chat c where c.user1.userId=:idr and c.user2.userId=:ids  order by c.dateSend desc",
				String.class);
		query.setParameter("idr", idr);
		query.setParameter("ids", ids);

		String ls;

		ls = query.getResultList().get(0);

		String[] splited = ls.split("\\s+");
		System.out.println("contenu = "+ls);

		
		ArrayList<Word> p= new ArrayList<>();

		

		for (int x = 0; x < splited.length; x++) {
			TypedQuery<String> query4 = em.createQuery("select  w.type from Word w where w.word=:mot", String.class);
			query4.setParameter("mot", splited[x]);
			List<String> types = new ArrayList<>();

			types = query4.getResultList();
			System.out.println("splitted = "+splited[x]);
			System.out.println("type du mot du mgs = "+types);

				//la liste des mgs de meme types 
			//s7y7a ama comm pour le test 
			/*
			TypedQuery<String> queryt = em.createQuery("select b.word from Word b where b.type=:type ", String.class);*/
			TypedQuery<Word> queryt = em.createQuery("select  b from Word b where b.type=:type ", Word.class);
			queryt.setParameter("type", types);

			List<Word> wls = new ArrayList<>();

			wls = queryt.getResultList();
			System.out.println("liste de meme type  = "+wls);


			

			p = (ArrayList<Word>) queryt.getResultList();


		}
int j ; 
ArrayList<Word> mo = new ArrayList<>();

		for(j=0; j < 3 ;j++)
		{
			mo.add(p.get(j));
	}

		return mo;

	}

	@Override
	public String getRecei(int idr) {
		TypedQuery<String> query = em.createQuery("select u.firstName from User u  where u.userId=:idr", String.class);
		query.setParameter("idr",idr);
		String ls ;

		ls = query.getSingleResult();
		System.out.println("nom = "+ls);
		return ls ;
	}

	@Override
	public int getidRecei(int idr) {
		ArrayList<Integer> p;

		TypedQuery<Integer> query = em.createQuery("select u.userId from User u  where u.userId=:idr", Integer.class);
		query.setParameter("idr",idr);
		int ls ;
		p = (ArrayList<Integer>)query.getResultList();
		ls=p.get(0);

		ls = query.getSingleResult();
		System.out.println("id receiver = "+ls);
		return ls ;
		
	
	}

}
