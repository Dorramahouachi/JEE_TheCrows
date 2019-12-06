//package tn.esprit.pidev.rest.resources;
//
//import javax.ejb.EJB;
//import javax.enterprise.context.RequestScoped;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
//import javax.ws.rs.GET;
//import javax.ws.rs.PUT;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.Response.Status;
//
//import tn.esprit.pidev.entities.Evaluation;
//import tn.esprit.pidev.services.impl.EvaluationCriteriaService;
//import tn.esprit.pidev.services.impl.EvaluationService;
//import tn.esprit.pidev.services.impl.UserService;
//
//
//
//@Path("evaluations")
//@RequestScoped
//public class EvauationResource {
//
//	
//	@EJB
//	EvaluationService evaluationService;
//	
//	@EJB
//	EvaluationCriteriaService evaluationCriteriaService;
//	
//	
//	@EJB
//	UserService userService;
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getEvaluations() {
//		return Response.status(Status.OK).entity(evaluationService.getAllEvaluations()).build();
//	}
//	
//	
//	@GET
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getEvaluationById(@PathParam(value="id") int id) {
//		Evaluation e = evaluationService.getEvaluationById(id);
//		if( e != null) {
//			return Response.status(Status.OK).entity(e).build();
//		}
//		return 	Response.status(Status.NOT_FOUND).entity("Votre evaluation n'a pas été trouvé").build();
//	}
//	
//	@PUT
//	@Path("{id}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response updateEvaluation(@PathParam(value="id") int id, Evaluation e ) {
//		for(Evaluation ev : evaluationService.getAllEvaluations()) {
//			if(ev.getId() == id);
//			{
//				evaluationService.updateEvaluation(id, e.getGlobalNote(), e.getDescription());
//				return Response.status(Status.OK).entity("update succesful").build();
//			}
//		}
//		return 	Response.status(Status.NOT_FOUND).entity("Votre evaluation n'a pas été trouvé").build();
//	}
//	
//	@DELETE
//	@Path("{id}")
//	public Response deleteEvaluation(@PathParam(value="id") int id) {
//		for (Evaluation e : evaluationService.getAllEvaluations()) {
//			if (e.getId()==id) {
//				evaluationService.deleteEvaluation(id);
//				//evaluations.deleteEvaluationById(id);
//				return Response.status(Status.GONE).entity("deleted").build();
//			}
//		}
//		return 	Response.status(Status.NOT_FOUND).entity("not deleted").build();
//
//
//	}
//}
