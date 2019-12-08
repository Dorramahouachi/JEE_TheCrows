package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

}
