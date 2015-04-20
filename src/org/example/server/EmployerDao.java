package org.example.server;

import java.util.List;

import javax.ejb.Local;

@Local
public interface EmployerDao {
	public Employer create(Employer employer);
	public Employer update(Employer employer);
	public void delete(int id);
	public Employer retrieve(int id);
	public List<Employer> retrieve();
	public List<EmploymentDTO> retrieveComplex();
}
