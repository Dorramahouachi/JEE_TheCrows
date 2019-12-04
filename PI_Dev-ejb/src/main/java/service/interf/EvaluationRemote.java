package service.interf;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;

import model.Evaluation;

@Remote
@LocalBean
public interface EvaluationRemote {
	
	public void addEvaluation(Evaluation eval);
	public void deleteEvaluation(int id);
	public void updateEvaluation(Evaluation eval);
	public Evaluation getEvaluationById(int id);
	public List<Evaluation> getAllEvaluations();

}
