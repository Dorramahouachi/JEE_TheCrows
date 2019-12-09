package ManagedBeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import model.EvaluationCriteria;
import services.impl.EvaluationCriteriaService;
import services.impl.EvaluationService;

@ManagedBean(name="criteriaBean")
@SessionScoped
public class CriteriaBean implements Serializable {

	
	@EJB
	EvaluationCriteriaService criteriaService;


	private String criteriaName;
	private List<EvaluationCriteria> criterias;
	private List<EvaluationCriteria> allCriterias;
	
	private String note; 
	
	
	public String deleteCriteria(int criteriaId) {
		criteriaService.deleteCriteria(criteriaId);
		return "evaluation?faces-redirect=true"; 

	}

	public String addCriteria() {
		criteriaService.addCriteria(new EvaluationCriteria(criteriaName, 0));
		return "evaluation?faces-redirect=true"; 


	}

	public List<EvaluationCriteria> getCriterias() {
		List<EvaluationCriteria> allCriterias = criteriaService.getAllCriterias();
		System.out.println("ayaaaaaaaaaaaa critééééééééére " + criteriaService.getCriteriasNotes(22));
		return allCriterias;
	}

	public String getCriteriaName() {
		return criteriaName;
	}

	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}

	public void setCriterias(List<EvaluationCriteria> criterias) {
		this.criterias = criterias;
	}
	public EvaluationCriteriaService getCriteriaService() {
		return criteriaService;
	}

	public void setCriteriaService(EvaluationCriteriaService criteriaService) {
		this.criteriaService = criteriaService;
	}

	public String getNote() {
		return note;
	}

	public void setNote(int criteriaId, int note) {
		criteriaService.affectNote(criteriaId, note);
	}
	
	public void modifierCritere(int id, String nom) {
		criteriaService.updateCriteria(id,nom);
	}

	public List<EvaluationCriteria> getAllCriterias() {
		return criteriaService.getAllCriterias();
	}

	public void setAllCriterias(List<EvaluationCriteria> allCriterias) {
		this.allCriterias = allCriterias;
	}
	
	
	
}
