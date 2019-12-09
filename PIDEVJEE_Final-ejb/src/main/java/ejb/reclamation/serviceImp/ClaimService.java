package ejb.reclamation.serviceImp;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ejb.reclamation.service.ClaimServiceRemote;
import model.Claim;

@Stateless
@LocalBean

public class ClaimService implements ClaimServiceRemote {

	@PersistenceContext(unitName = "primary")
	EntityManager em;
	



	
	public void DeleteClaim(Claim claim) {
		
		System.out.println("aaaaaaaaaaaaaaaaaaaaa ");
		em.remove(em.merge(claim));

		System.out.println("Out of removeemp : ");
	}

 

	public long getNombreclaimJPQL() {
		System.out.println(em);
		Query query=em.createQuery("SELECT COUNT(e) FROM Claim e");	
		long n=	(long)query.getSingleResult();
		return n;
	}

	
	public List<String> getAllclaimNamesJPQL() {
		List<String> noms= em.createQuery("SELECT e.nom FROM Claim e", String.class).getResultList();
		return noms;
	}

	
	public List<Claim> getAllClaim() {
		
		System.out.println("fiiiiiiiiindAlllllllllllll");

				return em.createQuery("Select e from Claim e",
						Claim.class).getResultList();

	}
	
public int  getnbpost(){
		
		Long mm =((Long) em.createQuery("select count(*) from Claim c where c.userId=1").getSingleResult());
		int k =mm.intValue();
		System.out.println("Couuuuuuuuuunt     " + k);

		return k;

	}
	 

	public Claim getclaimByEmailAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void UpdateClaim(Claim claim) {
		em.merge(claim);
		
	}



	
	
	public Claim ajouterclaim(Claim claim) {
		//System.out.println("In addemp : ");
	//	 Claim c=new Claim();
		// c.setName("ffff");
		

		//c.setName(claim.getName());
	//	c.setDateClaim(claim.getDescription());
	//	c.setDescription(claim.getDateClaim());
	//	c.setUserId(1);
		em.persist(claim);
		System.out.println("Out of addemp" + claim.getName());
		System.out.println("Out of addemp" + claim.getDescription());
		System.out.println("Out of addemp" + claim.getDescription());
		System.out.println("Out of addemp" + claim.getUserId());

	//	return claim===========
		return claim;
	}


	





	

	

}
