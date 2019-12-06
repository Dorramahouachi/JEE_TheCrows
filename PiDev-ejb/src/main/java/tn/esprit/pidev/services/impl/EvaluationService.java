//package tn.esprit.pidev.services.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.ejb.LocalBean;
//import javax.ejb.Stateless;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//
//import tn.esprit.pidev.entities.Claim;
//import tn.esprit.pidev.entities.CriteriaNote;
//import tn.esprit.pidev.entities.Evaluation;
//import tn.esprit.pidev.entities.EvaluationCriteria;
//import tn.esprit.pidev.entities.UserTwo;
//import tn.esprit.pidev.enums.EvaluationType;
//import tn.esprit.pidev.services.interfaces.EvaluationServiceRemote;
//
//@Stateless
//@LocalBean
//public class EvaluationService implements EvaluationServiceRemote {
//
//	@PersistenceContext
//	EntityManager em;
//
//	@Override
//	public int createSelfEvaluation(Evaluation evaluation, int employeeId, int managerId) {
//		evaluation.setType(EvaluationType.Self_Assessment);
//		UserTwo manager = em.find(UserTwo.class, managerId);
//		UserTwo employee = em.find(UserTwo.class, employeeId);
//		em.persist(evaluation);
//		return evaluation.getId();
//		
//	}
//
//	@Override
//	public void affectEvaluationToUser(int evaluationId, int managerId, int employeeId) {
//		Evaluation evaluation = em.find(Evaluation.class, evaluationId);
//		evaluation.setType(EvaluationType.Hierarchical_Evaluation);
//		UserTwo manager = em.find(UserTwo.class, managerId);
//		UserTwo employee = em.find(UserTwo.class, employeeId);
//		if(evaluation == null) {
//			Evaluation ev = new Evaluation();
//			ev.setType(EvaluationType.Hierarchical_Evaluation);
//			ev.setSender(manager);
//			ev.setReceiver(employee);
//		}
//		evaluation.setSender(manager);
//		evaluation.setReceiver(employee);
//		
//	}
//
//	@Override
//	public List<Evaluation>  getEvaluationByUser(int userId, String type) {
//		UserTwo emp = em.find(UserTwo.class, userId);
//		List<Evaluation> evList = new ArrayList<>();
//		for (Evaluation ev : emp.getEvaluationsReceived()) {
//			if(ev.getType().equals(type) ) {
//				evList.add(ev);
//			}
//		}
//		return evList;
//	}
//
//	@Override
//	public List<Evaluation> getAllEvaluations() {
//		List<Evaluation> evaluations = em.createQuery("SELECT e FROM Evaluation e", Evaluation.class).getResultList();
//		try {
////			for(Evaluation e: evaluations) {
//////				int s=0;
//////				Query sql = em.createNativeQuery("select notes, count(note) from EVALUATION_CRITERIA_NOTE where evaluation_id = :id ")
//////						.setParameter("id", e.getId());
//////				int count = ((Number) sql.getSingleResult()).intValue();
//////				
//////				float note 
//////				
//////				int update = em.createQuery("update Evaluation e set e.globalNote = :note where e.id= :id")
//////						.setParameter("note", note)
//////						.setParameter("id", e.getId())
//////						.executeUpdate();
////				
////				
////				int s = 0 ;
////				for(EvaluationCriteria cr : e.getCriterias()) {
////					float note = 0;
////					for( CriteriaNote getCrNote : cr.getCriteriaNotes()) {
////						s = s + getCrNote.getNote();
////						System.out.println("lesssssssssss notes"+ getCrNote.getNote());
////					}
////					
////					note = s/cr.getCriteriaNotes().size();
////					e.setGlobalNote(note);
////					int query = em.createQuery("update Evaluation e set e.globalNote = :note where e.id= :id")
////							.setParameter("note", note)
////							.setParameter("id", e.getId())
////							.executeUpdate();
////					System.out.println("upadate yes "+ query);
////					
////				}
////				
////				
////			}
//			
//			
//		}catch(Exception e) {
//			System.out.println("error in gettin note " + e);
//		}
//		return evaluations;
//	}
//
//	
//	
//
//	@Override
//	public void addEvalation(Evaluation ev) {
//		try {
//			em.persist(ev);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Override
//	public List<EvaluationCriteria> getEvaluationCriterias(int evaluationId) {
//		TypedQuery<EvaluationCriteria> query =  
//				em.createQuery("SELECT ec FROM EvaluationCriteria ec inner join ec.evaluations e WHERE e.id = :evaluationId",EvaluationCriteria.class)
//					.setParameter("evaluationId",evaluationId); 
//		
//		if(query.getResultList() == null) {
//			System.out.println("pas de critéres");
//		}	
//		return query.getResultList();
//	}
//
//	@Override
//	public Claim getClaimByEvaluation(int evaluationId) {
//		TypedQuery<Claim> query =  em.createQuery("SELECT c FROM Claim c join Evaluation e WHERE e.id = :evaluationId", Claim.class);
//		query.setParameter("evaluationId",evaluationId); 
//		return query.getSingleResult();
//	}
//
//	@Override
//	public void deleteEvaluation(int evaluationId) {
//		try {
//			em.remove(em.find(Evaluation.class, evaluationId));
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Override
//	public void addCriteria(Evaluation evaluation, EvaluationCriteria cr) {
//		Evaluation ev = em.find(Evaluation.class, evaluation);
//		ev.getCriterias().add(cr);
//		
//		
//		
//	}
//
//	@Override
//	public List<EvaluationCriteria> getAllEvaluationCriterias() {
//		List<EvaluationCriteria> allCriterias = em.createQuery("SELECT e FROM EvaluationCriteria e", EvaluationCriteria.class).getResultList();
//		return allCriterias;
//	}
//
//	@Override
//	public List<Evaluation> getEvaluationsReceived(int userId) {
//		List<Evaluation> mesEvaluations = em.createQuery("SELECT e from Evaluation e JOIN e.receiver rc WHERE rc.id = :userId", Evaluation.class)
//				.setParameter("userId", userId)
//				.getResultList();
//		
//		if(mesEvaluations == null) {
//			System.out.println("Pas de evaluations");
//		}
//		System.out.println(mesEvaluations);
//		return mesEvaluations;
//	}
//
//	public Evaluation getLatestEvaluation() {
//		Evaluation ev = em.createQuery("select e from Evaluation e ORDER BY  e DESC", Evaluation.class)
//				.getSingleResult();
//		return ev;
//				
//	}
//	
//	public void updateEvaluation(int id, float note, String description) {
////		Evaluation e =em.createQuery("select e from Evaluation e where e.id = :id", Evaluation.class)
////				.setParameter("id", id)
////				.getSingleResult();
////		e.setGlobalNote(note);
////		return e;
//		 em.createQuery("update Evaluation e set e.globalNote = :note, e.description= :description where e.id= :id")
//				.setParameter("note", note)
//				.setParameter("id", id)
//				.setParameter("description", description)
//				.executeUpdate();
//		
//	}
//	
//	public Evaluation getEvaluationById(int id) {
//		return em.createQuery("select e from Evaluation e where e.id = :id", Evaluation.class)
//				.setParameter("id", id)
//				.getSingleResult();
//	}
//
//}
