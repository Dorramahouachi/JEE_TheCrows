package service.interf;

import java.util.List;

import model.Candidature;



import javax.ejb.Remote;

import model.Candidature;

@Remote
public interface CandidatureServiceRemote {
	public List<Candidature> getAllCandidatures();
	public Candidature getCandidatureById(int id);

}
