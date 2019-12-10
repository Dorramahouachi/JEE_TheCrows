package services;

import java.util.List;

import javax.ejb.Remote;

import models.Subscribe;

@Remote
public interface SubscribeServiceRemote {

	public int getNumberSubscribes(int idEntreprise);
	public void addSubscribe(int idEntreprise, int idUser);
	public void removeSubscribe(int idEntreprise, int idUser);
	public List<Subscribe> getAll();
}
