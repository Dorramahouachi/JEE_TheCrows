package managedbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import model.EntretienPhysique;
import service.impl.EntretienPhysiqueService;


@ManagedBean(name="EntretienPhysiqueBean")
@ViewScoped
public class EntretienPhysiqueBean {
	private int EntretienPhysiqueId;
	private Date EntretienPhysiqueDate;

	private int candidature;

	@EJB
	EntretienPhysiqueService EntretienPhysiqueService; 
	
	private List<EntretienPhysique> EntretienPhysiques;
		
	

	public List<EntretienPhysique> getEntretienPhysique() {
		EntretienPhysiques = EntretienPhysiqueService.getAllEntretienPhysique(); 	
		return EntretienPhysiques;
		} 
	
	
	public EntretienPhysiqueService getEntretienPhysiqueService() {
		return EntretienPhysiqueService;
	}




	public void setEntretienPhysiqueService(EntretienPhysiqueService entretienPhysiqueService) {
		this.EntretienPhysiqueService = entretienPhysiqueService;
	}
	
	public int getEntretienPhysiqueId() {
		return EntretienPhysiqueId;
	}

	public void setEntretienPhysiqueId(int EntretienPhysiqueId) {
		this.EntretienPhysiqueId = EntretienPhysiqueId;
	}

	public Date getEntretienPhysiqueDate() {
		return EntretienPhysiqueDate;
	}

	public void setEntretienPhysiqueDate(Date EntretienPhysiqueDate) {
		this.EntretienPhysiqueDate = EntretienPhysiqueDate;
	}



	public int getcandidature() {
		return candidature;
	}

	public void setcandidature(int candidature) {
		this.candidature = candidature;
	}

	public void setEntretienPhysique(List<EntretienPhysique> EntretienPhysiques) {
		this.EntretienPhysiques = EntretienPhysiques;
	}

}
