package org.example.server;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.ejb3.annotation.SecurityDomain;

@ApplicationScoped
@Path("/farmer")
@Transactional
@SecurityDomain("keycloak")
public class FarmerService {

  @PersistenceContext
  private EntityManager em;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Farmer> retrieve() {
	return em.createNamedQuery("Farmer.findAll", Farmer.class).getResultList();
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Farmer retrieve(@PathParam("id") Integer id) {
	return em.find(Farmer.class, id);
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Farmer create(Farmer farmer) {
	farmer.setId(0);
	em.persist(farmer);
	return farmer;
  }  

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Farmer update(@PathParam("id") Integer id, Farmer farmer) {
	em.merge(farmer);
	return farmer;	
  }
  
  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public void delete(@PathParam("id") Integer id) {
	em.remove(retrieve(id));
  }
}
