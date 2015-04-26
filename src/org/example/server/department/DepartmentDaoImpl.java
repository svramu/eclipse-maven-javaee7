package org.example.server.department;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DepartmentDaoImpl implements DepartmentDao {

	@PersistenceContext
	private EntityManager em;
	
    public DepartmentDaoImpl() {}

	@Override
	public Department create(Department department) {
		em.persist(department);
		return department;
	}

	@Override
	public Department update(Department department) {
		em.merge(department);
		return department;	
	}

	@Override
	public void delete(int id) {
		em.remove(retrieve(id));
	}

	@Override
	public Department retrieve(int id) {
		return em.find(Department.class, id);
	}

	@Override
	public List<Department> retrieve() {
		return em.createNamedQuery("Department.findAll", Department.class).getResultList();
	}
    

}
