package service.impl;

import java.util.ArrayList;
import java.util.Date;
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
		List<Candidature> list =new ArrayList<Candidature>();
		List<Candidature> candidatures = em.createQuery("Select c from Candidature c", Candidature.class).getResultList();
		for(Candidature c : candidatures)
			if(c.getEtat()==5)
				list.add(c);
		return list;
	}
	@Override
	public Candidature getCandidatureById(int id) {
		// TODO Auto-generated method stub
		return em.find(Candidature.class, id);
	}

}
