package service.impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Candidature;
import model.Critere;
import model.CritereType;
import model.Evaluation;
import service.interf.EvaluationRemote;

@Stateful
public class EvaluationService implements EvaluationRemote{
	
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;

	@Override
	public int addEvaluation(Evaluation eval) {
		// TODO Auto-generated method stub
		//Candidature c = eval.getCandidature();
		em.persist(eval);
		//c.setEvaluation(eval);
		//em.merge(c);
		return eval.getEvaluationID();
	}

	@Override
	public void deleteEvaluation(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(Evaluation.class, id));
	}

	@Override
	public void updateEvaluation(Evaluation eval) {
		// TODO Auto-generated method stub
		Evaluation e = em.find(Evaluation.class, eval.getEvaluationID());
		e.setDescription(eval.getDescription());
		em.merge(e);
	}

	@Override
	public Evaluation getEvaluationById(int id) {
		// TODO Auto-generated method stub
		return em.find(Evaluation.class, id);
	}

	@Override
	public List<Evaluation> getAllEvaluations() {
		// TODO Auto-generated method stub
		return em.createQuery("Select e from Evaluation e",Evaluation.class).getResultList();
	}

	@Override
	public Long Chart(int id, CritereType type) {
		// TODO Auto-generated method stub
		/*Query query = em.createQuery("select count(*) from Critere where type=:type");
		query.setParameter("type", type);
		Long count = (Long) query.getSingleResult();
		return count;
		*/
		Evaluation eval = em.find(Evaluation.class, id);
		List<Critere> listCriteres = eval.getListCriteres();
		Long cpt = 0L;
		for(Critere c: listCriteres) {
			if(c.getType()==type)
				cpt++;
		}
		return cpt;
	}
}
