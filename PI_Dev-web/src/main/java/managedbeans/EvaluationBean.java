package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Candidature;
import model.Critere;
import model.CritereType;
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

	private Evaluation evaluation;
	
	////////////////// Critere
	private String name;
	private CritereType type;

	private int selectedEvalId;

	public void ajouterCritere() {

		Critere c = new Critere();
		c.setCritereName(name);
		c.setType(type);
		c.setEvaluation(service.getEvaluationById(selectedEvalId));
		serviceCritere.AddCritere(c);
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Successfull " ));
	}

	public void supprimerCritere(int id) {
		serviceCritere.DeleteCritere(id);
	}
	private List<Evaluation> listEval;
	private List<Critere> listCriteres;

	public void ajouterEval() {
		Evaluation eval = new Evaluation();
		eval.setDescription(description);
		eval.setCandidature(serviceCandidature.getCandidatureById(selectedCandidatureId));
		selectedEvalId = service.addEvaluation(eval);
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Success"));
	}

	public String goToEvalsList() {
		return "listEval.jsf?faces-redirect=true";
	}

	public String goToCriteresList(int id) {
		selectedEvalId = id;
		return "listCriteres.jsf?faces-redirect=true";
	}

	public void supprimerEval(int id) {
		service.deleteEvaluation(id);
	}

	private int evalToBeUpdatedID;

	public int getEvalToBeUpdatedID() {
		return evalToBeUpdatedID;
	}

	public void setEvalToBeUpdatedID(int evalToBeUpdatedID) {
		this.evalToBeUpdatedID = evalToBeUpdatedID;
	}

	public void modifier() {
		Evaluation s = new Evaluation();
		s.setCandidature(candidature);
		s.setDescription(description);
		s.setEvaluationID(selectedEvalId);
		service.updateEvaluation(s);
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Successfull " ));
	}

	public String toGerer(Evaluation eval) {
		this.setCandidature(eval.getCandidature());
		this.setDescription(eval.getDescription());
		this.setListCriteres(eval.getListCriteres());
		this.setSelectedEvalId(eval.getEvaluationID());
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Successfull " ));
		String navigaTo = null;
		navigaTo = "updateEval.jsf?faces-redirect=true";
		return navigaTo;
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

	public CritereRemote getServiceCritere() {
		return serviceCritere;
	}

	public void setServiceCritere(CritereRemote serviceCritere) {
		this.serviceCritere = serviceCritere;
	}

	public static int idEvalChart;
	
	public List<Critere> getListCriteres() {
		idEvalChart = selectedEvalId;
		System.out.println("test5 " + selectedEvalId);
		System.out.println("test6 " + idEvalChart);
		return serviceCritere.getCritereByEval(selectedEvalId);
	}

	public void setListCriteres(List<Critere> listCriteres) {
		this.listCriteres = listCriteres;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CritereType getType() {
		return type;
	}

	public void setType(CritereType type) {
		this.type = type;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	public int getSelectedEvalId() {
		return selectedEvalId;
	}

	public void setSelectedEvalId(int selectedEvalId) {
		this.selectedEvalId = selectedEvalId;
	}

}
