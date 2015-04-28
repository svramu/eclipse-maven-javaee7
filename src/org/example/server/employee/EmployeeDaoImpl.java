package org.example.server.employee;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return em.createNamedQuery("Employee.findForEmployer", Employee.class)
				.setParameter("employerId", employerId)
				.getResultList();
	}
}
