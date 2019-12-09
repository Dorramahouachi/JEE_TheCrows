package services;

import java.util.List;

import models.Entrepris;
import javax.ejb.Remote;

@Remote
public interface entrepriseServiceRemote {

	public List<Entrepris> getAll();
	public Entrepris getOne(int id);
}
