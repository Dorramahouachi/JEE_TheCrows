package services;

import javax.ejb.Remote;


@Remote
public interface CandidatServiceRemote {

	public int getUser(int id);
}
