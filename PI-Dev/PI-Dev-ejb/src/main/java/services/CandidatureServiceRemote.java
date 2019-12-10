package services;

import java.util.List;

import javax.ejb.Remote;
import models.Candidature;;

@Remote
public interface CandidatureServiceRemote {

	public void AddCandidature(int idOffer, int idUser);
	public void RemoveCandidature(int idOffer);
	public List<Candidature> getAll();
	public Candidature getOne(int id);
	
}
