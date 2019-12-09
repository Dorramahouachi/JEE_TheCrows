package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FlowEvent;
import model.Candidature;
import model.EntretienPhysique;
import model.Critere;
import model.CritereType;
import model.Evaluation;
import service.interf.CandidatureServiceRemote;
import service.interf.CritereRemote;
import service.interf.EntretienPhysiqueRemote;
import service.interf.EvaluationRemote;

@ManagedBean(name = "evaluationBean")
@ApplicationScoped
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
	EntretienPhysiqueRemote serviceEntretienPhysique;
	@EJB
	CritereRemote serviceCritere;
	private int id;
	private String ponctuality;
	private String description;
	private int selectedCandidatureId;
	private int selectedEntretienPhysiqueId;
	private Date EntretienPhysiqueDate;
	private int NoteEval;

	private Candidature candidature;
	private Evaluation evaluation;
	private EntretienPhysique EntretienPhysique;
	////////////////// Critere
	private String name;
	private CritereType type;

	private int selectedEvalId;

	@PostConstruct
	public void init() {
		System.out.println("requesting....");
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:1911/Calendriers/GetEvents");
		System.out.println("response  : " + target.request(MediaType.APPLICATION_JSON).get(String.class).toString());
	}

	public String getPonctuality() {
		return ponctuality;
	}

	public void setPonctuality(String ponctuality) {
		this.ponctuality = ponctuality;
	}

	public Date getEntretienPhysiqueDate() {
		return EntretienPhysiqueDate;
	}

	public void setEntretienPhysiqueDate(Date entretienPhysiqueDate) {
		EntretienPhysiqueDate = entretienPhysiqueDate;
	}

	public void ajouterCritere() {

		System.out.println(selectedEvalId + "test200");
		Critere c = new Critere();
		c.setCritereName(name);
		c.setType(type);
		c.setEvaluation(service.getEvaluationById(selectedEvalId));
		serviceCritere.AddCritere(c);
		name = null;
		type = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfull "));
	}

	public void supprimerCritere(int id) {
		serviceCritere.DeleteCritere(id);
	}

	private List<Evaluation> listEval;
	private List<Critere> listCriteres;

	/*
	 * public void ajouterEval() { Evaluation eval = new Evaluation();
	 * eval.setDescription(description);
	 * eval.setEntretienPhysique(serviceEntretienPhysique.getEntretienPhysiqueById(
	 * 14)); eval.setCandidature(serviceCandidature.getCandidatureById(
	 * selectedCandidatureId)); selectedEvalId = service.addEvaluation(eval);
	 * idEvalChart = selectedEvalId; eval.setNoteEval(NoteEval);
	 * FacesContext.getCurrentInstance().addMessage(null, new
	 * FacesMessage("Success")); }
	 */
	public String goToEvalsList() {
		return "listEval.jsf?faces-redirect=true";
	}

	public String goToCriteresList(int id) {
		selectedEvalId = id;
		idEvalChart = selectedEvalId;
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

	public String modifier(FlowEvent event) {

		if (verif == 0) {
			Evaluation s = new Evaluation();
			s.setDescription(description);
			s.setEvaluationID(selectedEvalId);
			s.setCandidature(candidature);
			if (s.getDescription() != null && s.getCandidature() != null) {
				service.updateEvaluation(s);

				description = null;
				selectedCandidatureId = 0;
				idEvalChart = selectedEvalId;
				verif2 = 1;
				System.out.println(selectedEvalId + "test201");
			}
			System.out.println(selectedEvalId + "test201");

			return event.getNewStep();
		}
		System.out.println(selectedEvalId + "test201");

		return event.getNewStep();

	}

	public String toGerer(Evaluation eval) {
		this.setCandidature(eval.getCandidature());
		this.setEntretienPhysique(eval.getEntretienPhysique());
		this.setDescription(eval.getDescription());
		this.setListCriteres(eval.getListCriteres());
		this.setSelectedEvalId(eval.getEvaluationID());
		idEvalChart = selectedEvalId;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successfull "));
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
		System.out.println("test1000 " + selectedEvalId);
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

	private boolean skip;

	public String save() {
		description = null;
		selectedCandidatureId = 0;
		verif = 0;
		// listCriteres.clear();
		name = null;
		type = null;
		// selectedEvalId=0;
		FacesMessage msg = new FacesMessage("Successful");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "listEval.jsf?faces-redirect=true";

	}

	public String save2() {
		description = null;
		selectedCandidatureId = 0;
		verif2 = 0;
		// listCriteres.clear();
		name = null;
		type = null;
		// selectedEvalId=0;
		FacesMessage msg = new FacesMessage("Successful");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "listEval.jsf?faces-redirect=true";

	}

	public EntretienPhysique getEntretienPhysique() {
		return EntretienPhysique;
	}

	public void setEntretienPhysique(EntretienPhysique entretienPhysique) {
		EntretienPhysique = entretienPhysique;
	}

	public boolean isSkip() {
		return skip;
	}

	public int getNoteEval() {
		return NoteEval;
	}

	public void setNoteEval(int noteEval) {
		NoteEval = noteEval;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	int verif = 0;
	int verif2 = 0;

	public String onFlowProcess(FlowEvent event) {

		System.out.println(description + "test100");
		System.out.println(selectedCandidatureId + "test100");
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			if (verif == 0) {
				Evaluation eval = new Evaluation();
				eval.setDescription(description);
				eval.setEntretienPhysique(serviceEntretienPhysique.getEntretienPhysiqueById(14));
				eval.setCandidature(serviceCandidature.getCandidatureById(selectedCandidatureId));
				eval.setNoteEval(NoteEval);
				if (eval.getDescription() != null && eval.getCandidature() != null
						&& eval.getEntretienPhysique() != null) {
					selectedEvalId = service.addEvaluation(eval);
					description = null;
					selectedCandidatureId = 0;
					idEvalChart = selectedEvalId;
					verif = 1;
					System.out.println(selectedEvalId + "test201");
				}
				System.out.println(selectedEvalId + "test201");

				return event.getNewStep();
			}
			System.out.println(selectedEvalId + "test201");

			return event.getNewStep();
		}
	}

	public static int getIdEvalChart() {
		return idEvalChart;
	}

	public static void setIdEvalChart(int idEvalChart) {
		EvaluationBean.idEvalChart = idEvalChart;
	}

	public int getVerif() {
		return verif;
	}

	public void setVerif(int verif) {
		this.verif = verif;
	}

	public int getSelectedEntretienPhysiqueId() {
		return selectedEntretienPhysiqueId;
	}

	public void setSelectedEntretienPhysiqueId(int selectedEntretienPhysiqueId) {
		this.selectedEntretienPhysiqueId = selectedEntretienPhysiqueId;
	}

}
