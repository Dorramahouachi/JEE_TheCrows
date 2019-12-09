package ejb.reclamation.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Claim;


 
@Remote
public interface ClaimServiceRemote {
	public Claim ajouterclaim(Claim claim);
    public void DeleteClaim(Claim claim);
	public void UpdateClaim(Claim claim);
	 public int getnbpost();

	public List<Claim> getAllClaim();
 
}
