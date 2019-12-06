package tn.esprit.pidev.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.entities.Claim;
import tn.esprit.pidev.entities.Evaluation;
import tn.esprit.pidev.entities.EvaluationCriteria;
import tn.esprit.pidev.entities.UserTwo;

@Remote
public interface EvaluationServiceRemote {

	public List<Evaluation> getAllEvaluations();
	public void addEvalation(Evaluation ev);
	public void deleteEvaluation(int evaluationId);
	public int createSelfEvaluation(Evaluation evaluation, int employeeId, int managerId);
	public void affectEvaluationToUser(int evaluationId,int managerId, int employeeId);
	public List<Evaluation> getEvaluationByUser(int userId, String type);
	public List<EvaluationCriteria> getEvaluationCriterias(int evaluationId);
	public List<EvaluationCriteria> getAllEvaluationCriterias();
	public void addCriteria(Evaluation evaluation, EvaluationCriteria cr);
	public Claim getClaimByEvaluation(int evaluationId);
	public List<Evaluation> getEvaluationsReceived(int userId);
	
	
}
