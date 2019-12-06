package services;

import java.util.List;

import javax.ejb.Remote;

import models.Offer;

@Remote
public interface OfferServiceRemote {
	public List<Offer> getAll();
}
