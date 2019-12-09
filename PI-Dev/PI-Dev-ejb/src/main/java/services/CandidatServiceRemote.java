package services;

import javax.ejb.Remote;

import models.User;


@Remote
public interface CandidatServiceRemote {

	public User getUser(int id);
}
