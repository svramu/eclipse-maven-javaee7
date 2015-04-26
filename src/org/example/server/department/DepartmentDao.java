package org.example.server.department;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DepartmentDao {
	public Department create(Department department);
	public Department update(Department department);
	public void delete(int id);
	public Department retrieve(int id);
	public List<Department> retrieve();
}
