package tn.esprit.pidev.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.entities.Evaluation;
import tn.esprit.pidev.entities.EvaluationCriteria;
import tn.esprit.pidev.enums.EvaluationType;

@Remote
public interface EvaluationCriteriaServiceRemote {

	public List<EvaluationCriteria> getAllCriterias();
	public void addCriteria(EvaluationCriteria ec);
	public void deleteCriteria(int criteriaId);
	public List<EvaluationCriteria> getCriteriasByEvaluationType(EvaluationType evaluationType);
	public void affectCriteriaToEvaluation(EvaluationCriteria cr, Evaluation e);
	public void affectNote(int id, int note);
	public void affectNoteToCriteriaEvaluation(int note, Evaluation e, int crId);
	public List<EvaluationCriteria> getCriteriasNotes(int evaluationId);
	
	
}
