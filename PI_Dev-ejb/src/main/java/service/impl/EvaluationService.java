package service.impl;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Evaluation;
import service.interf.EvaluationRemote;

@Stateful
public class EvaluationService implements EvaluationRemote{
	
	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;

	@Override
	public void addEvaluation(Evaluation eval) {
		// TODO Auto-generated method stub
		em.persist(eval);
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
}
