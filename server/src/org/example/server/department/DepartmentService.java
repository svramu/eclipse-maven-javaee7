package org.example.server.department;

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
@Path("/department")
@SecurityDomain("keycloak")
public class DepartmentService {

  @EJB
  DepartmentDao departmentDao;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Department> retrieve() {
    return departmentDao.retrieve();
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Department retrieve(@PathParam("id") Integer id) {
	  return departmentDao.retrieve(id);
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Department create(Department department) {
	  department.setId(0);
	  return departmentDao.create(department);
  }  

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Department update(@PathParam("id") Integer id, Department department) {
    return departmentDao.update(department);
  }
  
  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public void delete(@PathParam("id") Integer id) {
    departmentDao.delete(id);
  }
}
