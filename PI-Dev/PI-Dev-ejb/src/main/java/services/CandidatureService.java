package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Candidature;
import models.Entrepris;
import models.Offer;
import models.User;

@Stateless
@LocalBean
public class CandidatureService implements CandidatureServiceRemote{

	@PersistenceContext
	EntityManager em;
	@Override
	public void AddCandidature(int idOffer, int idUser) {
		Offer o = new Offer();
		User u = new User();
		TypedQuery<User> query = em.createQuery("select u from User u WHERE u.userId=:idUser", User.class); 
		query.setParameter("idUser", idUser); 
		u=query.getSingleResult();
		TypedQuery<Offer> query1 = em.createQuery("select o from Offer o WHERE o.offerId=:idOffer", Offer.class); 
		query1.setParameter("idOffer", idOffer); 
		o=query1.getSingleResult();
		Candidature c = new Candidature();
		c.setOffer(o);
		c.setUser(u);
		c.setEtat("En cours");
		em.persist(c);
	}
	@Override
	public List<Candidature> getAll() {
		List<Candidature> can = em.createQuery("Select e from Candidature e",Candidature.class).getResultList();
		return can;
	}
	@Override
	public void RemoveCandidature(int idOffer) {
		em.createQuery("DELETE FROM Candidature c WHERE c.offer.offerId=:idOffer").setParameter("idOffer", idOffer).executeUpdate();
	}
	@Override
	public Candidature getOne(int id) {
		Candidature can = em.createQuery("Select e from Candidature e where e.candidatureId=:id",Candidature.class).setParameter("id", id).getSingleResult();
		return can;
	}
}
