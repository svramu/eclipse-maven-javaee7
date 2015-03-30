package org.example.server;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersonDaoImpl implements PersonDao {

	@PersistenceContext
	private EntityManager em;
	
    public PersonDaoImpl() {}

	@Override
	public Person create(Person person) {
		em.persist(person);
		return person;
	}

	@Override
	public Person update(Person person) {
		em.merge(person);
		return person;	
	}

	@Override
	public void delete(int id) {
		em.remove(retrieve(id));
	}

	@Override
	public Person retrieve(int id) {
		return em.find(Person.class, id);
	}

	@Override
	public List<Person> retrieve() {
		return em.createNamedQuery("Person.findAll", Person.class).getResultList();
	}
    

}
