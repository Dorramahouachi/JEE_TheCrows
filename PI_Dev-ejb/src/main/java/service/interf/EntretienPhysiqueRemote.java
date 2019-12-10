package service.interf;

import java.util.Date;
import java.util.List;

import model.Candidature;
import model.EntretienPhysique;

import javax.ejb.Remote;

import model.Candidature;

@Remote
public interface EntretienPhysiqueRemote {
	public List<EntretienPhysique> getAllEntretienPhysique();
	public EntretienPhysique getEntretienPhysiqueById(int id);
	public Date getDateById(Date date);

}
