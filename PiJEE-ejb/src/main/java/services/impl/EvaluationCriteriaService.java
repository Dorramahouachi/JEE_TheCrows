package services.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.CriteriaNote;
import model.Evaluation;
import model.EvaluationCriteria;
import model.enums.EvaluationType;
import services.interfaces.EvaluationCriteriaServiceRemote;


@Stateless
@LocalBean
public class EvaluationCriteriaService implements EvaluationCriteriaServiceRemote {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<EvaluationCriteria> getAllCriterias() {
		List<EvaluationCriteria> criterias = em.createQuery("SELECT e FROM EvaluationCriteria e", EvaluationCriteria.class).getResultList();
		return criterias;
	}

	@Override
	public void addCriteria(EvaluationCriteria ec) {
		Boolean found = false;
		String crName = ec.getCriteria();
		try{
			TypedQuery<String> query = em.createQuery("SELECT e.criteria from EvaluationCriteria e", String.class);

			for(String name: query.getResultList()) {
				if(name.equals(crName)) {
					found=true;	
				}
			}
			if(found == false) {
				em.persist(ec);
			}
			else {
				System.out.println("La critére existe déja !");
			}

		}catch(Exception e) {
			System.out.println(e);
		}
	
		
		
	}

	@Override
	public void deleteCriteria(int criteriaId) {
		em.remove(em.find(EvaluationCriteria.class, criteriaId));
		
	}

	@Override
	public List<EvaluationCriteria> getCriteriasByEvaluationType(EvaluationType evaluationType) {
		TypedQuery<EvaluationCriteria> query = em.createQuery(" SELECT c EvaluationCriteria c join Evaluation e where e.type =:type", EvaluationCriteria.class);
		query.setParameter("type",evaluationType);
		return query.getResultList();
	}

	@Override
	public void affectCriteriaToEvaluation(EvaluationCriteria cr, Evaluation e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affectNote(int id, int note) {
		try {
			EvaluationCriteria ec = em.find(EvaluationCriteria.class, id);
			ec.setNote(note);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public void updateCriteria(int id, String nom) {
		try {
			int query= em.createQuery("update EvaluationCriteria ec set ec.criteria= :nom where id= :id")
					.setParameter("nom",nom)
					.setParameter("id", id)
					.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void affectNoteToCriteriaEvaluation(int note, Evaluation e, int criteriaId) {
		try {
//			Evaluation ev = em.find(Evaluation.class, evaluationId);
			EvaluationCriteria ec = em.find(EvaluationCriteria.class, criteriaId);
			CriteriaNote crNote = new CriteriaNote(note, ec, e);
			em.persist(crNote);
			
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public List<EvaluationCriteria> getCriteriasNotes(int evaluationId) {
		List<EvaluationCriteria> allCriterias = 
		em.createQuery("select ec from EvaluationCriteria ec join ec.criteriaNotes notes join notes.evaluation evaluation where evaluation.id= :id ", EvaluationCriteria.class)
		.setParameter("id", evaluationId)
		.getResultList();
	
		return allCriterias;
	}
	
	public void updateCriteriasForSelfAssessment(int criteriaId , int note, int evaluationId) {
		try {
		String name = em.createQuery( "select ec.name from EvaluationCriteria ec where ec.id= :id",  String.class)
				.setParameter("id", criteriaId)
				.getSingleResult();
		EvaluationCriteria crit  = new EvaluationCriteria(name,0);
		CriteriaNote cn = em.createQuery("select cn from CriteriaNote cn join cn.evaluation cne e join cn.criteria cnc where cne.id = :evid and cnc.id = :cid ", CriteriaNote.class)
				.setParameter("evid", evaluationId)
				.setParameter("cid", criteriaId)
				.getSingleResult();
		int modified = em.createQuery("update CriteriaNote cn set note= :note  cn.id= :id").setParameter("id", cn.getId()).executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	

}
