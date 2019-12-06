//package tn.esprit.pidev.managedbeans;
//
//import java.io.Serializable;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.ejb.EJB;
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//import javax.servlet.http.HttpServletRequest;
//
//import tn.esprit.pidev.entities.CriteriaNote;
//import tn.esprit.pidev.entities.Evaluation;
//import tn.esprit.pidev.entities.EvaluationCriteria;
//import tn.esprit.pidev.entities.UserTwo;
//import tn.esprit.pidev.enums.EvaluationType;
//import tn.esprit.pidev.services.impl.EvaluationCriteriaService;
//import tn.esprit.pidev.services.impl.EvaluationService;
//import tn.esprit.pidev.services.impl.UserService;
//
//@ManagedBean(name="evaluationBean")
//@SessionScoped
//public class EvaluationBean implements Serializable {
//
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private Date date;
//	private String description; 
//	private EvaluationType type ; 
//	private UserTwo manager;
//	private UserTwo employe;
//	private int selectedEvaluation;
//	private Evaluation evaluation; 
//	private String criteriaName;
//	private float globalNote;
//	private int employeId;
//	private int note;
//	
//	
//	@ManagedProperty(value = "#{criteriaBean}")
//	private CriteriaBean criteres;
//	
//	@ManagedProperty(value = "#{loginBean}")
//	private LoginBean loginBean;
//	
//	
//	private List<EvaluationCriteria> criterias;
//	private List<Evaluation> evaluations;
//	private List<Evaluation> filteredEvaluations;
//	private List<UserTwo> users;
//	private List<CriteriaNote> notes;
//	
//	@EJB
//	EvaluationService evaluationService;
//	
//	@EJB
//	EvaluationCriteriaService evaluationCriteriaService;
//	
//	@EJB 
//	UserService userService;
//
//	
//	
//	public void deleteEvaluation(int id) {
//		evaluationService.deleteEvaluation(id);
//
//	}
//	
//
//	public int getId() {
//        FacesContext contexto = FacesContext.getCurrentInstance();
//        HttpServletRequest req = (HttpServletRequest) contexto.getExternalContext().getRequest();
//        return Integer.parseInt(req.getParameter("pid"));
//    }
//	
//	
//	
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
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
//	public Evaluation getEvaluation() {
//		return evaluation;
//	}
//
//	public void setEvaluation(Evaluation evaluation) {
//		this.evaluation = evaluation;
//	}
//
//	
//	
//	public float getNoteGlobal() {
//		return globalNote;
//	}
//
//	public void setNoteGlobal(float noteGlobal) {
//		this.globalNote = noteGlobal;
//	}
//
//	public List<EvaluationCriteria> getCriterias() {
//		List<EvaluationCriteria> allCriterias = evaluationService.getAllEvaluationCriterias();
//		return allCriterias;
//	}
//
//	public void setCriterias(List<EvaluationCriteria> criterias) {
//		this.criterias = criterias;
//	}
//
//	public List<Evaluation> getEvaluations() {
//		List<Evaluation> evaluations = evaluationService.getAllEvaluations();
//		return evaluations;
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
//	public UserService getUserService() {
//		return userService;
//	}
//
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
//
//	public EvaluationType getType() {
//		return type;
//	}
//
//	public void setType(EvaluationType type) {
//		this.type = type;
//	}
//
//	public UserTwo getEmploye() {
//		return employe;
//	}
//
//	public void setEmploye(UserTwo employe) {
//		this.employe = employe;
//	}
//	
//
//	public UserTwo getManager() {
//		return manager;
//	}
//
//	public void setManager(UserTwo manager) {
//		this.manager = manager;
//	}
//
//	public List<UserTwo> getUsers() {
//		return userService.getUsesDistinctFromLoggedUser(loginBean.getLoggedUser().getId());
//	}
//
//	public void setUsers(List<UserTwo> users) {
//		this.users = users;
//	}
//	
//	public String getCriteriaName() {
//		return criteriaName;
//	}
//
//	public void setCriteriaName(String criteriaName) {
//		this.criteriaName = criteriaName;
//	}
//
//	public String addEvaluation() {
//		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//		Date date = new Date(System.currentTimeMillis());	
//		employe = userService.getUserById(employeId);
//		manager=this.loginBean.user;
//
//		System.out.println("critéressssssssssssssssssssssssssssssssssss " + this.criteres.getCriterias().toString());
//		Evaluation evaluation = new Evaluation(this.type, this.description, date, this.manager, this.employe, this.criteres.getCriterias());
//
//		evaluationService.addEvalation(evaluation);
//		Evaluation latest = evaluationService.getAllEvaluations().get(evaluationService.getAllEvaluations().size()-1);
//		
//		
//		
//		for(EvaluationCriteria ec: this.criteres.getCriterias()) {
//			evaluationCriteriaService.affectNoteToCriteriaEvaluation(ec.getNote(), evaluation, ec.getId());
//		}
//		addMessage("Evaluation Envoyé");
//		return "listeEvaluations?faces-redirect=true"; 
//	}
//	
//	public void setNote(int criteriaId) {
//		evaluationCriteriaService.affectNote(criteriaId, note);
//	}
//	
//	
//	public void addMessage(String summary) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
//	
////	public String goToAdd() {
////		return "addEvaluation?faces-redirect=true"; 
////	}
//	public String goBack() {
//		return "welcome?faces-redirect=true"; 
//	}
//
//	public int getSelectedEvaluation() {
//		return selectedEvaluation;
//	}
//
//	public void setSelectedEvaluation(int selectedEvaluation) {
//		this.selectedEvaluation = selectedEvaluation;
//	}
//
//	public CriteriaBean getCriteres() {
//		return criteres;
//	}
//
//	public void setCriteres(CriteriaBean criteres) {
//		this.criteres = criteres;
//	}
//
//	public int getEmployeId() {
//		return employeId;
//	}
//
//	public void setEmployeId(int employeId) {
//		this.employeId = employeId;
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
//
//	public List<Evaluation> getFilteredEvaluations() {
//		return filteredEvaluations;
//	}
//
//
//	public void setFilteredEvaluations(List<Evaluation> filteredEvaluations) {
//		this.filteredEvaluations = filteredEvaluations;
//	}
//	public String goTostats(){
//		return "evaluationStats?faces-redirect=true";
//	}
//
//
//	public List<CriteriaNote> getNotes() {
//		return notes;
//	}
//
//
//	public void setNotes(List<CriteriaNote> notes) {
//		this.notes = notes;
//	}
//
//
//	public int getNote() {
//		return note;
//	}
//
//	
//	
//	
//	
//	
//	
//	
//}
