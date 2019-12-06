package Beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import models.Offer;

import java.util.List;

import javax.ejb.EJB;
import services.OfferServiceRemote;

@ManagedBean(name="searchMB")
@RequestScoped
public class SearchMB {
	@EJB
	private OfferServiceRemote metier;
	private String titleOffer;
	private String location;
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	private int reference;
	private String data;
	private String data1;
	public String getData1() {
		return data1;
	}

	public void setData1(String data1) {
		this.data1 = data1;
	}

	private List<Offer> listOffers ;
	
	
	public List<Offer> getListOffers() {
		return listOffers;
	}

	public void setListOffers(List<Offer> listOffers) {
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
}
