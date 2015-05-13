package org.example.server.employee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.example.server.employer.Employer;
import org.example.server.region.Region;

@Stateless
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;
	
    public EmployeeDaoImpl() {}

	@Override
	public Employee create(Employee employee) {
		em.persist(employee);
		return employee;
	}

	@Override
	public Employee update(Employee employee) {
		em.merge(employee);
		return employee;	
	}

	@Override
	public void delete(int id) {
		em.remove(retrieve(id));
	}

	@Override
	public Employee retrieve(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public List<Employee> retrieve() {
		return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
	}
    
	@Override
	public List<Employee> retrieveEmployees(int employerId) {
		//TODO: Make this a proper HTTP I18n error code 
		Employer employer = em.find(Employer.class, employerId);
		if(employer == null) throw new RuntimeException("No such employerId: "+employerId);
		
		return em.createNamedQuery("Employee.findForEmployer", Employee.class)
				.setParameter("employerId", employerId)
				.getResultList();
	}

	@Override
	public List<Region> retrieveRegions(int employeeID) {
		Employee employee = em.find(Employee.class, employeeID);
		return employee.getRegion();
	}

	@Override
	public Employee relateRegion(int employeeID, int regionID) {
		Employee employee = em.find(Employee.class, employeeID);
		Region region = em.find(Region.class, regionID);
		
		employee.getRegion().add(region);
		em.merge(employee);
		return employee;	
	}

}
