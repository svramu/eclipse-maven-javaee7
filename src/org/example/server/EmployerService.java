package org.example.server;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
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
@Path("/employer")
@SecurityDomain("keycloak")
public class EmployerService {

  @EJB
  EmployerDao employerDao;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Employer> retrieve() {
    return employerDao.retrieve();
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Employer retrieve(@PathParam("id") Integer id) {
	  return employerDao.retrieve(id);
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Employer create(Employer employer) {
	  employer.setId(0);
	  return employerDao.create(employer);
  }  

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Employer update(@PathParam("id") Integer id, Employer employer) {
    return employerDao.update(employer);
  }
  
  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public void delete(@PathParam("id") Integer id) {
    employerDao.delete(id);
  }
}
