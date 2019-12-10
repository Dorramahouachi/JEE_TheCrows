package services;

import model.Chat;

import model.User;
import model.Word;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
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
				"select  c  from Chat c  where c.user1.userId=:id and c.vue =:vue  order by c.dateSend asc ",
				Chat.class);
		query.setParameter("id", id);
		query.setParameter("vue", vue);

		p = (ArrayList<Chat>) query.getResultList();

		return p;

	}
// la condition a verifier 
	@Override
	public ArrayList<Chat> dropList(int id) {
		ArrayList<Chat> p;
		TypedQuery<Chat> query = em
				.createQuery("select  c  from Chat c  where c.user1.userId=:id  order by c.dateSend asc ", Chat.class);
		query.setParameter("id", id);

		p = (ArrayList<Chat>) query.getResultList();

		System.out.println("p = " + p);
		ArrayList<User> u;
		TypedQuery<User> queryu = em.createQuery("select  c  from User c  where c.userId !=:id ", User.class);
		queryu.setParameter("id", id);

		u = (ArrayList<User>) queryu.getResultList();
		System.out.println("u = " + u);

		ArrayList<Chat> mo = new ArrayList<>();

		Chat ch = null;
		for (int j = 0; j < u.size(); j++) {
			mo.add(ch);
			for (int i = 0; i < p.size(); i++) {

				if (p.get(i).getUser2().getUserId() == u.get(j).getUserId()) {
					mo.set(j, p.get(i));
				}
			}
		}

		return mo;
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
		p = (ArrayList<User>) query.getResultList();
		e = p.get(0);
		e.toString();
		return e;
	}

	@Override
	public ArrayList<User> getUsrs(int id) {
		ArrayList<User> p;
		TypedQuery<User> query = em.createQuery("select c  from User c  where c.userId !=:id ", User.class);
		query.setParameter("id", id);

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

	

	@Override
	public void updateChat(Chat e) {
		Chat x = new Chat();
		x = em.find(Chat.class, e.getChatId());
		x.setContenu(e.getContenu());
		
		
			em.merge(x);
	

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
		System.out.println("contenu = " + ls);

		ArrayList<Word> p = new ArrayList<>();

		for (int x = 0; x < splited.length; x++) {
			// je recupere le type du mot mel table word
			TypedQuery<String> query4 = em.createQuery("select  w.type from Word w where w.word=:mot", String.class);
			query4.setParameter("mot", splited[x]);
			List<String> types = new ArrayList<>();

			types = query4.getResultList();
			System.out.println("splitted = " + splited[x]);
			System.out.println("type du mot du mgs = " + types);
			//je recupere les mot de meme liste 
			TypedQuery<Word> queryt = em.createQuery("select  b from Word b where b.type=:type ", Word.class);
			queryt.setParameter("type", types);

			List<Word> wls = new ArrayList<>();

			wls = queryt.getResultList();
			System.out.println("liste de meme type  = " + wls);

			p = (ArrayList<Word>) queryt.getResultList();

		}
		
		if(p.size()!=0)
		{int j;
		ArrayList<Word> mo = new ArrayList<>();

		for (j = 0; j < 3; j++) {
			mo.add(p.get(j));
		}
	
		return mo;

		}
		ArrayList<Word> vi = new ArrayList<>();
		return vi ; 


	}

	@Override
	public String getRecei(int idr) {
		TypedQuery<String> query = em.createQuery("select u.firstName from User u  where u.userId=:idr", String.class);
		query.setParameter("idr", idr);
		String ls;

		ls = query.getSingleResult();
		System.out.println("nom = " + ls);
		return ls;
	}

	@Override
	public int getidRecei(int idr) {
		ArrayList<Integer> p;

		TypedQuery<Integer> query = em.createQuery("select u.userId from User u  where u.userId=:idr", Integer.class);
		query.setParameter("idr", idr);
		int ls;
		p = (ArrayList<Integer>) query.getResultList();
		ls = p.get(0);

		ls = query.getSingleResult();
		System.out.println("id receiver = " + ls);
		return ls;

	}


	
	
	public String deleteChatId1(int id) {
		/*Chat c = em.find(Chat.class, id);

		em.remove(c);*/
		Chat c = em.find(Chat.class, id);

		LocalDateTime now = LocalDateTime.now();
		System.out.println("min now " + now.getMinute());
		System.out.println("min date " + c.getDateSend().getMinutes());
		long diff = now.getMinute() - c.getDateSend().getMinutes();
		System.out.println("dif min ="+diff);
		// here
		
		//test
		SimpleDateFormat ss = new SimpleDateFormat("dd");
	    System.out.println("days date "+ss.format(c.getDateSend()));
		System.out.println("days of now "+now.getDayOfMonth());

	    int d = Integer.parseInt( ss.format(c.getDateSend()));
		System.out.println("d= " + d);

	    long days = (now.getDayOfMonth() - d) ;

		//end test 
		System.out.println("days diff = " + days);
		// end
		// here
		long month = (now.getMonthValue() - c.getDateSend().getMonth()) - 1;
		System.out.println("month = " + month);
		// end
		if (month > 1) {
		
			return "late";
		} else {
			if (days > 1) {
				

				return "late";
			} else {
				if (diff > 10) {


					return "late";
				}
				else {
					em.remove(c);
					return "ok";}
			}
		}

	}

	@Override
	public void view(int ids, int idr) {

		TypedQuery<Chat> query =em.createQuery(
		"select c from Chat c  where c.user1.userId=:idR and c.user2.userId=:idS", Chat.class	);
			query.setParameter("idR", idr);
			query.setParameter("idS", ids);
		
		List<Chat> ls = new ArrayList<>();

		ls = query.getResultList();
		System.out.println("ls = "+ls);
		for ( int i=0 ; i<ls.size();i++)
		{
			Chat x = new Chat();
			x = em.find(Chat.class, ls.get(i).getChatId());
			x.setVue(1);
			
			
				em.merge(x);
			
		}
		
	}
	

}