package org.example.server;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


/**
 * The persistent class for the employer database table.
 * 
 */
@Entity
@Table(name="employer")
@NamedQuery(name="Employer.findAll", query="SELECT e FROM Employer e")

//http://stackoverflow.com/a/21487061
//http://docs.oracle.com/javaee/7/api/javax/persistence/ConstructorResult.html
//http://stackoverflow.com/questions/22663502/how-to-use-constructorresult-annotation
@SqlResultSetMapping(name="complexDtoMapping", 
	classes = {@ConstructorResult( targetClass = EmploymentDTO.class, 
	    columns = {
			@ColumnResult(name="employer_name"), 
			@ColumnResult(name="employee_id"),
			@ColumnResult(name="employee_name")
		})
	}
)

public class Employer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="employer", fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Employee> employees;
	//OH! it becomes cyclic dependency
	
	public Employer() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setEmployer(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setEmployer(null);

		return employee;
	}

}