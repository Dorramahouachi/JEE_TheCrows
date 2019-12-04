package service.impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Critere;
import model.CritereType;
import service.interf.CritereRemote;

@Stateful
public class CritereService implements CritereRemote {

	@PersistenceContext(unitName="imputation-ejb")
	EntityManager em;

	@Override
	public void AddCritere(Critere critere) {
		// TODO Auto-generated method stub
		em.persist(critere);
	}

	@Override
	public void DeleteCritere(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Critere.class, id));
	}

	@Override
	public void updateCritere(Critere critere) {
		// TODO Auto-generated method stub
		Critere c = em.find(Critere.class, critere.getCritereID());
		c.setCritereName(critere.getCritereName());
		c.setType(critere.getType());
		em.merge(c);
	}

	@Override
	public Critere getCritere(int id) {
		// TODO Auto-generated method stub
		return em.find(Critere.class, id);
	}

	@Override
	public List<Critere> getAllCriteres() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT c from Critere c", Critere.class).getResultList();
	}

	@Override
	public List<Critere> getCritereByType(CritereType type) {
		// TODO Auto-generated method stub
		return em.createQuery("select c from Critere c where c.type=:type ", Critere.class).setParameter("type", type)
				.getResultList();
	}

	@Override
	public Long chartCritere(CritereType type) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select count(*) from Critere where type=:type");
		query.setParameter("type", type);
		Long count = (Long) query.getSingleResult();
		return count;
	}

}
