package service.interf;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;

import model.Critere;
import model.CritereType;

@Remote
@LocalBean
public interface CritereRemote {

	public void AddCritere(Critere critere);
	public void DeleteCritere(int id);
	public void updateCritere(Critere critere);
	public Critere getCritere(int id);
	public List<Critere> getAllCriteres();
	public List<Critere> getCritereByType(CritereType type);
	public Long chartCritere(CritereType type);
	public List<Critere> getCritereByEval(int id);
	
}
