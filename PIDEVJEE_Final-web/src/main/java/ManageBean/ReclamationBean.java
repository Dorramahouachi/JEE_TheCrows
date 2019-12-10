package ManageBean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.servlet.http.HttpSession;


import ejb.reclamation.serviceImp.ClaimService;
import model.Claim;



@ManagedBean(name = "ReclamationBean") 
@SessionScoped
public class ReclamationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date dateClaim = new Date();
	private String description;
	private String name;
	private List<Claim> claim;
	private int userId;
	private int val=0;
	private int claimIdtobeupdated;
	public int getClaimIdtobeupdated() {
		return claimIdtobeupdated;
	}
	public void setClaimIdtobeupdated(int claimIdtobeupdated) {
		this.claimIdtobeupdated = claimIdtobeupdated;
	}
	private boolean formDisplayed = false;
	private boolean formDis1 = false ;
	private List<Claim> listClaims = new ArrayList<Claim>();
    Claim claim2 = new Claim();
    FacesContext facesContext = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession)facesContext.getExternalContext().getSession(true);
	@EJB
	ClaimService claimservice;
	
	
	  @PostConstruct
		public void init(){
	    	System.out.println("*****uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
	     	listClaims = claimservice.getAllClaim();

	    	setListClaims(claimservice.getAllClaim());
	    //	setListe(cvServiceLocal.findAllSkills());
	    	val=0;
	    	val = claimservice.getnbpost();
	    	System.out.println("*****   " + val);
	    	formDisplayed=false;

	    	if(val<=4)
	    	{
	    	    	formDisplayed = false;

	    	}else {
			formDisplayed = true;}
			}	
	public void addClaim() {
		val=0;
	val = claimservice.getnbpost();

	Claim c = new Claim();
	c.setName(name);
	c.setDescription(description);
	c.setDateClaim(dateClaim);
	c.setUserId(1);
	
if(val<=4)
{
	System.out.println("*kkkkkk"+ c.getDateClaim());

		claimservice.ajouterclaim(c);
    	setListClaims(claimservice.getAllClaim());
    	formDisplayed = false;

}
else {
	setListClaims(claimservice.getAllClaim());

	formDisplayed = true;

}



		}
	
	
		public void removeClaim(Claim claim)
		{ claimservice.DeleteClaim(claim);
	//	claimservice.DeleteClaim(claimId);
     	listClaims = claimservice.getAllClaim();
     	formDisplayed = true;
     	
		
		}
		
		/**public void updateClaim(Claim claim)
		{ 
			System.out.println("*kkkkkk"+ claim.getClaimId());
			name=claim.getName();
description= claim.getDescription();
dateClaim=claim.getDateClaim();
System.out.println("*naaaaaaaaaaaaaame"+ claim.getClaimId());
System.out.println("*description"+ claim.getClaimId());
System.out.println("*dateClaim"+ claim.getClaimId());

			//claimservice.UpdateClaim(claim);
     	listClaims = claimservice.getAllClaim();
     	formDisplayed = true;
     	
		
		}
		
		public void update1Claim(Claim claim)
		{ 
			claim.setName(name);
			claim.setDescription(description);
			claim.setDateClaim(dateClaim);
			claim.setClaimId(claimIdtobeupdated);

			//PromotionService.updatePromotion(new Promotion(PromotionIdToBeUpdate,title, promotiontype, promotionunit, createdate, validuntil, product));
			claimservice.UpdateClaim(claim);
			System.out.println("*id"+ claim.getClaimId());
			System.out.println("*Newdescription"+ claim.getDescription());
			System.out.println("*NewdateClaim"+ claim.getDateClaim());
			System.out.println("*Newdeqscription"+ claim.getDescription());

     	listClaims = claimservice.getAllClaim();
     	formDisplayed = true;
     	
		
		}*/


		public String updateclaim(Claim c)
		{ 
			this.setName(c.getName());
			this.setDescription(c.getDescription());
			this.setDateClaim(c.getDateClaim());
			System.out.println("*daaaaaaaaate"+c.getDateClaim());


	
	     this.setClaimIdtobeupdated(c.getClaimId());
	     	listClaims = claimservice.getAllClaim();

		return "/Pages/Claim/Modifier?faces-redirect=true";
		
		}
		public String mettreAjour(){

			claimservice.UpdateClaim(new Claim(claimIdtobeupdated,name, dateClaim, description));
	     	listClaims = claimservice.getAllClaim();

			return "/Pages/Claim/AllClaims?faces-redirect=true";
			}

		
		public Date getDateClaim() {
			return dateClaim;
		}
		public void setDateClaim(Date dateClaim) {
			this.dateClaim = dateClaim;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getVal() {
			return val;
		}
		public void setVal(int val) {
			this.val = val;
		}
		public void modifier(Claim claim)
		{
		this.setDescription(claim.getDescription());
		this.setName(claim.getName());
		}
		
		public List<Claim> getAllClaim() {
			claim = claimservice.getAllClaim();
			System.out.println("*********************************************");

			return claim;
			}

	/*public String getDateClaim() {
			return dateClaim;
		}
		public void setDateClaim(String dateClaim) {
			this.dateClaim = dateClaim;
		}
		*/
		
	public FacesContext getFacesContext() {
			return facesContext;
		}
		public void setFacesContext(FacesContext facesContext) {
			this.facesContext = facesContext;
		}
		public HttpSession getSession() {
			return session;
		}
		public void setSession(HttpSession session) {
			this.session = session;
		}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ClaimService getClaimservice() {
		return claimservice;
	}
	public void setClaimservice(ClaimService claimservice) {
		this.claimservice = claimservice;
	}
	public ReclamationBean() {
		super();
		
	}
	public List<Claim> getClaim() {
		return claim;
	}
	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}
	public boolean isFormDisplayed() {
		return formDisplayed;
	}
	public void setFormDisplayed(boolean formDisplayed) {
		this.formDisplayed = formDisplayed;
	}
	public boolean isFormDis1() {
		return formDis1;
	}
	public void setFormDis1(boolean formDis1) {
		this.formDis1 = formDis1;
	}
	public List<Claim> getListClaims() {
		return listClaims;
	}
	public void setListClaims(List<Claim> listClaims) {
		this.listClaims = listClaims;
	}
	public Claim getClaim2() {
		return claim2;
	}
	public void setClaim2(Claim claim2) {
		this.claim2 = claim2;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	

}
