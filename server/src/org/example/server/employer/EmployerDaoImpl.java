package org.example.server.employer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployerDaoImpl implements EmployerDao {

	@PersistenceContext
	private EntityManager em;
	
    public EmployerDaoImpl() {}

	@Override
	public Employer create(Employer employer) {
		em.persist(employer);
		return employer;
	}

	@Override
	public Employer update(Employer employer) {
		em.merge(employer);
		return employer;	
	}

	@Override
	public void delete(int id) {
		em.remove(retrieve(id));
	}

	@Override
	public Employer retrieve(int id) {
		return em.find(Employer.class, id);
	}

	@Override
	public List<Employer> retrieve() {
		return em.createNamedQuery("Employer.findAll", Employer.class).getResultList();
	}
    
	//TODO: rectify the dto mapping duplicate error
	//Caused by: org.hibernate.DuplicateMappingException: Duplicate resultSet mapping complexDtoMapping
	@Override
	public List<EmploymentDTO> retrieveComplex() {
		String q = "SELECT "
				+ "er.name as employer_name, "
				+ "ee.id as employee_id, "
				+ "ee.name as employee_name "
				+ "FROM employer2 er, employee2 ee "
				+ "WHERE ee.employer2_id=er.id";
		@SuppressWarnings("unchecked")
		List<EmploymentDTO> results = em.createNativeQuery(q, "complexDtoMapping").getResultList(); 
		return results;
	}

}
