package org.example.server.employee;

import java.util.List;

import javax.ejb.Local;

import org.example.server.region.Region;

@Local
public interface EmployeeDao {
	public Employee create(Employee employee);
	public Employee update(Employee employee);
	public void delete(int id);
	public Employee retrieve(int id);
	public List<Employee> retrieve();

	public List<Employee> retrieveEmployees(int employerId);
	public List<Region> retrieveRegions(int employeeID);
	public Employee relateRegion(int employeeID, int regionID);
}
