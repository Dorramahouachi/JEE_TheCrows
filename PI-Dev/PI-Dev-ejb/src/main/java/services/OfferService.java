package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
