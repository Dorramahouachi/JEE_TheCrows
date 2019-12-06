package Beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import models.Offer;

import java.util.List;

import javax.ejb.EJB;
import services.CandidatServiceRemote;
import services.OfferServiceRemote;

@ManagedBean(name="searchMB")
@RequestScoped
public class SearchMB {
	@EJB
	private OfferServiceRemote metier;
	private String titleOffer;
	private int reference;
	
	public String search() {
		metier.getAll();
		return "success" ;
	}

	public List<Offer> getlistOffers(){
		return metier.getAll();
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
