package org.example.server.person;

import java.util.List;

import javax.ejb.Local;

@Local
public interface PersonDao {
	public Person create(Person person);
	public Person update(Person person);
	public void delete(int id);
	public Person retrieve(int id);
	public List<Person> retrieve();
}
