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
@Path("/employee")
@SecurityDomain("keycloak")
public class EmployeeService {

  @EJB
  EmployeeDao employeeDao;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Employee> retrieve() {
    return employeeDao.retrieve();
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Employee retrieve(@PathParam("id") Integer id) {
	  return employeeDao.retrieve(id);
  }
  
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Employee create(Employee employee) {
	  employee.setId(0);
	  return employeeDao.create(employee);
  }  

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Employee update(@PathParam("id") Integer id, Employee employee) {
    return employeeDao.update(employee);
  }
  
  @DELETE
  @Path("/{id}")
  @Produces(MediaType.TEXT_PLAIN)
  public void delete(@PathParam("id") Integer id) {
    employeeDao.delete(id);
  }
}
