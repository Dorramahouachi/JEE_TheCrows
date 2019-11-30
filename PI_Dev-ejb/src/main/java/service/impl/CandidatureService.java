package service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Candidature;
import service.interf.CandidatureServiceRemote;

@Stateless
@LocalBean
public class CandidatureService implements CandidatureServiceRemote {
	
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
	@Override
	public List<Candidature> getAllCandidatures() {
		List<Candidature> candidatures = em.createQuery("Select c from Candidature c", Candidature.class).getResultList();
		
		return candidatures;
	}

}
