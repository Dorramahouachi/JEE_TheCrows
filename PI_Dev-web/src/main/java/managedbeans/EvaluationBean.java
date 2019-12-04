package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Candidature;
import model.Evaluation;
import service.interf.CandidatureServiceRemote;
import service.interf.CritereRemote;
import service.interf.EvaluationRemote;

@ManagedBean(name = "evaluationBean")
@SessionScoped
public class EvaluationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	EvaluationRemote service;
	
	@EJB
	CandidatureServiceRemote serviceCandidature;
	
	@EJB
	CritereRemote serviceCritere;
	
	private int id;
	private String description;
	private int selectedCandidatureId;
	private Candidature candidature;
	
	private List<Evaluation> listEval;
	
	public String ajouterEval() {
		Evaluation eval = new Evaluation();
		System.out.println("tessssssssst"+selectedCandidatureId);
		eval.setDescription(description);
		eval.setCandidature(serviceCandidature.getCandidatureById(selectedCandidatureId));
		service.addEvaluation(eval);
		return "listEval.jsf?faces-redirect=true";
	}
	
	public String goToCriteresList() {
		return "listCriteres.jsf?faces-redirect=true";
	}
	public void supprimerEval(int id) {
		service.deleteEvaluation(id);
	}
	
	public EvaluationRemote getService() {
		return service;
	}
	public void setService(EvaluationRemote service) {
		this.service = service;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSelectedCandidatureId() {
		return selectedCandidatureId;
	}
	public void setSelectedCandidatureId(int selectedCandidatureId) {
		this.selectedCandidatureId = selectedCandidatureId;
	}
	public Candidature getCandidature() {
		return serviceCandidature.getCandidatureById(selectedCandidatureId);
	}
	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public EvaluationBean() {
	}
	public CandidatureServiceRemote getServiceCandidature() {
		return serviceCandidature;
	}
	public void setServiceCandidature(CandidatureServiceRemote serviceCandidature) {
		this.serviceCandidature = serviceCandidature;
	}
	public List<Evaluation> getListEval() {
		return service.getAllEvaluations();
	}
	public void setListEval(List<Evaluation> listEval) {
		this.listEval = listEval;
	}
	
	
}
