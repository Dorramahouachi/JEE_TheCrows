//package tn.esprit.pidev.managedbeans;
//
//import java.io.Serializable;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
//
//import tn.esprit.pidev.entities.Evaluation;
//import tn.esprit.pidev.entities.EvaluationCriteria;
//import tn.esprit.pidev.entities.UserTwo;
//import tn.esprit.pidev.enums.EvaluationType;
//import tn.esprit.pidev.services.impl.EvaluationCriteriaService;
//import tn.esprit.pidev.services.impl.EvaluationService;
//
//
//@ManagedBean(name="myEvaluationsBean")
//@SessionScoped
//public class MyEvaluationsBean implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	private Evaluation myEvaluation;
//	private List<Evaluation> evaluations;
//	private List<EvaluationCriteria> myEvaluationCriterias ;
//	private List<EvaluationCriteria> myNewEvaluationCriterias ;
//	private String description ; 
//	private int criteriaNote ; 
//	
//	@ManagedProperty(value = "#{loginBean}")
//	private LoginBean loginBean;
//	
//	
//	@EJB
//	EvaluationService evaluationService;
//	
//	@EJB
//	EvaluationCriteriaService evaluationCriteriaService;
//
//	public List<Evaluation> getEvaluations() {
//		return evaluationService.getEvaluationsReceived(LoginBean.user.getId());
//	}
//
//	public void setEvaluations(List<Evaluation> evaluations) {
//		this.evaluations = evaluations;
//	}
//
//	public EvaluationService getEvaluationService() {
//		return evaluationService;
//	}
//
//	public void setEvaluationService(EvaluationService evaluationService) {
//		this.evaluationService = evaluationService;
//	}
//	
//	public String sendSelfAssessment() {
//		return "selfAssessmentForm?faces-redirect=true" ;
//	}
//
//	public Evaluation getMyEvaluation() {
//		Evaluation evaluation = new Evaluation();
//		for (Evaluation e : getEvaluations()) {
//			System.out.println("type evaluation" + e.getType());
//			if(e.getType() == EvaluationType.Hierarchical_Evaluation ) {
//				evaluation = e;
//			}
//			else {
//				System.out.println("Evaluation introuvable");
//			}
//		}
//		return evaluation;
//	}
//
//	public void setMyEvaluation(Evaluation myEvaluation) {
//		this.myEvaluation = myEvaluation;
//	}
//
//	public List<EvaluationCriteria> getMyEvaluationCriterias() {
//		Evaluation ev = getMyEvaluation();
//		return evaluationCriteriaService.getCriteriasNotes(ev.getId());
//	}
//
//	public void setMyEvaluationCriterias(List<EvaluationCriteria> myEvaluationCriterias) {
//		this.myEvaluationCriterias = myEvaluationCriterias;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	
//	public String addEvaluation() {
//		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//		Date date = new Date(System.currentTimeMillis());
//		
//		Evaluation ev = new Evaluation(EvaluationType.Self_Assessment, description, date, loginBean.getLoggedUser(),myEvaluation.getSender(),myNewEvaluationCriterias);
//		evaluationService.addEvalation(ev);
//		return "listeEvaluations?faces-redirect=true";
//	}
//
//	public List<EvaluationCriteria> getMyNewEvaluationCriterias() {
//		return myNewEvaluationCriterias;
//	}
//
//	public void setMyNewEvaluationCriterias(List<EvaluationCriteria> myNewEvaluationCriterias) {
//		this.myNewEvaluationCriterias = myNewEvaluationCriterias;
//	}
//
//	public int getCriteriaNote() {
//		return criteriaNote;
//	}
//
//	public void setCriteriaNote(int criteriaNote) {
//		this.criteriaNote=criteriaNote;
//	}
//	
//	public void setNote(int criteriaId) {	
//		System.out.println(criteriaId);
//		evaluationCriteriaService.updateCriteriasForSelfAssessment(criteriaId, criteriaNote, getMyEvaluation().getId());
//
//	}
//
//	public LoginBean getLoginBean() {
//		return loginBean;
//	}
//
//	public void setLoginBean(LoginBean loginBean) {
//		this.loginBean = loginBean;
//	}
//
//	public EvaluationCriteriaService getEvaluationCriteriaService() {
//		return evaluationCriteriaService;
//	}
//
//	public void setEvaluationCriteriaService(EvaluationCriteriaService evaluationCriteriaService) {
//		this.evaluationCriteriaService = evaluationCriteriaService;
//	}
//	
//}
