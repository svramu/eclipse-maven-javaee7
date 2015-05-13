package org.example.server.region;

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
@Path("/region")
@SecurityDomain("keycloak")
public class RegionService {

  @EJB
  RegionDao regionDao;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Region> retrieve() {
    return regionDao.retrieve();
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Region retrieve(@PathParam("id") Integer id) {
	  return regionDao.retrieve(id);
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Region create(Region region) {
	  region.setId(0);
	  return regionDao.create(region);
  }  

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Region update(@PathParam("id") Integer id, Region region) {
    return regionDao.update(region);
  }
  
  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public void delete(@PathParam("id") Integer id) {
    regionDao.delete(id);
  }
}
