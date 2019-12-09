package service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Candidature;
import model.EntretienPhysique;
import service.interf.CandidatureServiceRemote;
import service.interf.EntretienPhysiqueRemote;


@Stateless
@LocalBean
public class EntretienPhysiqueService implements EntretienPhysiqueRemote {
	
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;
	@Override
	public List<EntretienPhysique> getAllEntretienPhysique() {
		List<EntretienPhysique> list =new ArrayList<EntretienPhysique>();
		List<EntretienPhysique> EntretienPhysique = em.createQuery("Select e from EntretienPhysique e", EntretienPhysique.class).getResultList();
		for(EntretienPhysique e : EntretienPhysique)
			//if(c.getDateEntretien() < )
				list.add(e);
		return list;
	}
	@Override
	public EntretienPhysique getEntretienPhysiqueById(int id) {
		// TODO Auto-generated method stub
		return em.find(EntretienPhysique.class, id);
	}
	@Override
	public Date getDateById(Date date )
	{
		TypedQuery<EntretienPhysique> query = em.createQuery("Select b from EntretienPhysique b where b.dateEntretien=:id", EntretienPhysique.class);
		((Query) query).setParameter("id", date);
		EntretienPhysique EP = query.getSingleResult();
		 Date dade = EP.getDateEntretien();
		return dade;
	}

}
