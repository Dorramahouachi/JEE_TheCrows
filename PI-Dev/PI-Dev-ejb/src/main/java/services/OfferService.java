package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Candidature;
import models.Offer;

@Stateless
@LocalBean
public class OfferService implements OfferServiceRemote {

	@PersistenceContext
	EntityManager em;
	@Override
	public List<Offer> getAll() {
		List<Offer> off = em.createQuery("Select e from Offer e",Offer.class).getResultList();
		return off;
	}
	@Override
	public List<Offer> getByName(String s) {
		List<Offer> off;
		TypedQuery<Offer> query = em.createQuery("Select e from Offer e where e.titleOffer like ?",Offer.class);;
		query.setParameter(1, "%"+s+"%");
		off = query.getResultList();
		return off;
	}
	@Override
	public List<Offer> getByLocation(String s) {
		List<Offer> off;
		TypedQuery<Offer> query = em.createQuery("Select e from Offer e where e.location like ?",Offer.class);;
		query.setParameter(1, "%"+s+"%");
		off = query.getResultList();
		return off;
	}
	@Override
	public void RemoveCandidature(int idOffer) {
		em.createQuery("DELETE FROM Candidature c WHERE c.OfferId=:idOffer").setParameter("idOffer", idOffer).executeUpdate();
	}
	@Override
	public Offer getTopJob() {
		Offer o = new Offer();
		//TypedQuery<Candidature> query = em.createQuery("Select c from Candidature c ORDERBY c.offre.offreId Desc", Candidature.class);
		TypedQuery<Candidature> query = em.createQuery("SELECT OfferId COUNT(OfferId) AS value_occurrence  FROM Candidature GROUP BY OfferId "
				+ "ORDER BY value_occurrence DESC LIMIT 1;", Candidature.class);
		Candidature c = new Candidature();
		c = query.getSingleResult();
		System.out.println(c.getOffer().getOfferId());
		return o;
	}
	

}
