package Beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import models.Candidature;
import models.Offer;
import models.User;

import java.util.List;

import javax.ejb.ApplicationException;
import javax.ejb.EJB;

import services.CandidatServiceRemote;
import services.CandidatureServiceRemote;
import services.OfferServiceRemote;

@ManagedBean(name="searchMB")
@ApplicationException
public class SearchMB {
	@EJB
	private OfferServiceRemote metier;
	@EJB
	private CandidatureServiceRemote metier1;
	@EJB
	private CandidatServiceRemote metier2;
	private int OfferId;
	private String titleOffer;
	private String location;
	private int reference;
	private String duration;
	private float salary;
	private String contractType;
	private String data;
	private String data1;
	private String data2;
	private int candidatureId;
	
	public int getCandidatureId() {
		return candidatureId;
	}

	public void setCandidatureId(int candidatureId) {
		this.candidatureId = candidatureId;
	}

	public String getData2() {
		return data2;
	}

	public void setData2(String data2) {
		this.data2 = data2;
	}

	private List<Offer> listOffers ;
	private List<Candidature> listCandidature ;
	private User UserCncte ;
	
	
	
	public List<Candidature> getListCandidature() {
		this.setListCandidature(metier1.getAll());
		return listCandidature;
	}

	public void setListCandidature(List<Candidature> listCandidature) {
		this.listCandidature = listCandidature;
	}

	public User getUserCncte() {
		this.setUserCncte(metier2.getUser(1));
		return UserCncte;
	}

	public void setUserCncte(User userCncte) {
		UserCncte = userCncte;
	}

	public CandidatServiceRemote getMetier2() {
		return metier2;
	}

	public void setMetier2(CandidatServiceRemote metier2) {
		this.metier2 = metier2;
	}

	public CandidatureServiceRemote getMetier1() {
		return metier1;
	}

	public void setMetier1(CandidatureServiceRemote metier1) {
		this.metier1 = metier1;
	}

	public int getOfferId() {
		return OfferId;
	}

	public void setOfferId(int offerId) {
		OfferId = offerId;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}
	
	public List<Offer> getListOffers() {
		return listOffers;
	}

	public void setListOffers(List<Offer> listOffers) {
		
		
		
		this.setListOffers(metier.getAll());

		this.listOffers = listOffers;
	}

	public String getTitleOffer() {
		return titleOffer;
	}

	public void setTitleOffer(String titleOffer) {
		this.titleOffer = titleOffer;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String search() {
		
		if(this.getData1().equals("1"))
			this.setListOffers(metier.getByName(this.getData()));
		else if(this.getData1().equals("2"))
			this.setListOffers(metier.getByLocation(this.getData()));
		else if(this.getData1().equals("3"))
			this.AllOffers();
		
		return "success" ;
	}
	
	public String filter(String data2) {
		this.setListOffers(metier.getByLocation(this.getData2()));
		return "success" ;
	}

	public List<Offer> AllOffers(){
		this.setListOffers(metier.getAll());
		return this.getListOffers();
	}
	public OfferServiceRemote getMetier() {
		return metier;
	}

	public void setMetier(OfferServiceRemote metier) {
		this.metier = metier;
	}

	public String getOffer() {
		return titleOffer;
	}

	public void setOffer(String offer) {
		this.titleOffer = offer;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}
	
	public String apply() {
		metier1.AddCandidature(1, 1);
		return "success";
	}
	
	public String ignore(int OfferId) {
		metier1.RemoveCandidature(OfferId);
		return "success";
	}
}
