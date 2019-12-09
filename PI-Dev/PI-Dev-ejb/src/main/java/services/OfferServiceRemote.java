package services;

import java.util.List;

import javax.ejb.Remote;

import models.Offer;

@Remote
public interface OfferServiceRemote {
	public List<Offer> getAll();
	public List<Offer> getByName(String s);
	public List<Offer> getByLocation(String s);
	public void RemoveCandidature(int idOffer);
}
