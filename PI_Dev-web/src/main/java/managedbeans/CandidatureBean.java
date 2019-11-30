package managedbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Candidature;
import model.User;
import service.impl.CandidatureService;




@ManagedBean(name="candidatureBean")
@SessionScoped
public class CandidatureBean {
	private int candidatureId;
	private Date candidatureDate;
	private String etat;
	private int score;
	private User user;
	
	

	@EJB
	CandidatureService candidatureService; 
	
	private List<Candidature> candidatures;
		
	

	public List<Candidature> getCandidatures() {
		candidatures = candidatureService.getAllCandidatures(); 
		for(Candidature can : candidatures ){
			
			if(can.getEtat()==1)
			{
				
			}
			else if (can.getEtat()==2)
			{
				setEtat("accepted");
			}
			else if (can.getEtat()==3)
			{
				setEtat("processing");
			}
			else if (can.getEtat()==4)
			{
				setEtat("Quizz");
			}
			else if (can.getEtat()==5)
			{
				setEtat("entretienPhysique");
			}
			
		}
		
		
		return candidatures;
		} 
	
	
	public CandidatureService getCandidatureService() {
		return candidatureService;
	}




	public void setCandidatureService(CandidatureService candidatureService) {
		this.candidatureService = candidatureService;
	}
	
	public int getCandidatureId() {
		return candidatureId;
	}

	public void setCandidatureId(int candidatureId) {
		this.candidatureId = candidatureId;
	}

	public Date getCandidatureDate() {
		return candidatureDate;
	}

	public void setCandidatureDate(Date candidatureDate) {
		this.candidatureDate = candidatureDate;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCandidatures(List<Candidature> candidatures) {
		this.candidatures = candidatures;
	}

}
