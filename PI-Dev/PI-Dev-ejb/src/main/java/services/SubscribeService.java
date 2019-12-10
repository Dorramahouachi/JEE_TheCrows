package services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import models.Entrepris;
import models.Subscribe;
import models.User;

@Stateless
@LocalBean
public class SubscribeService implements SubscribeServiceRemote{

	@PersistenceContext
	EntityManager em;
	@Override
	public int getNumberSubscribes(int idEntreprise) {
		TypedQuery<Subscribe> query = em.createQuery("select u from Subscribe u WHERE u.entrepris.entrepriseId=:id", Subscribe.class); 
		query.setParameter("id", idEntreprise); 
		int nb =query.getResultList().size();
		return nb;
	}
	
	@Override
	public void addSubscribe(int idEntreprise, int idUser) {
		Entrepris e = new Entrepris();
		User u = new User();
		TypedQuery<User> query = em.createQuery("select u from User u WHERE u.userId=:idUser", User.class); 
		query.setParameter("idUser", idUser); 
		u=query.getSingleResult();
		TypedQuery<Entrepris> query1 = em.createQuery("Select e from Entrepris e where e.entrepriseId=:id", Entrepris.class); 
		query1.setParameter("id", idEntreprise); 
		e=query1.getSingleResult();
		Subscribe c = new Subscribe();
		c.setEntrepris(e);
		c.setUser(u);
		Date utilDate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		c.setSubscribeDate(sqlDate);
		em.persist(c);
	}

	@Override
	public List<Subscribe> getAll() {
		List<Subscribe> can = em.createQuery("Select e from Subscribe e",Subscribe.class).getResultList();
		return can;
	}

	@Override
	public void removeSubscribe(int idEntreprise, int idUser) {
		em.createQuery("Delete FROM Subscribe s where s.entrepris.entrepriseId ="+idEntreprise+" and s.user.userId="+idUser).executeUpdate();
	}

}
