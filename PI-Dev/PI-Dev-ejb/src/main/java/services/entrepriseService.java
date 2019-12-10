package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import models.Entrepris;
import models.User;

@Stateless
@LocalBean
public class entrepriseService implements entrepriseServiceRemote{

	@PersistenceContext
	EntityManager em;
	@Override
	public List<Entrepris> getAll() {
		List<Entrepris> can = em.createQuery("Select e from Entrepris e",Entrepris.class).getResultList();
		return can;
	}
	@Override
	public Entrepris getOne(int id) {
		Entrepris can = em.createQuery("Select e from Entrepris e where e.entrepriseId=:id",Entrepris.class).setParameter("id", id).getSingleResult();
		return can;
	}

}
