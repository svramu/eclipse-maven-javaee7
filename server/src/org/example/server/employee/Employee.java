package org.example.server.employee;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.example.server.department.Department;
import org.example.server.region.Region;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQueries({
	@NamedQuery(name="Employee.findAll", 
			query="SELECT e FROM Employee e"),
	@NamedQuery(name="Employee.findForEmployer", 
			query="SELECT e FROM Employee e WHERE e.employer_id = :employerId"),
	@NamedQuery(name="Employee.findForDepartment", 
			query="SELECT e FROM Employee e WHERE e.department.id = :departmentId")
})
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private int employer_id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;
	
	@ManyToMany(fetch = FetchType.EAGER)
	//The following annotation is not required for my example, 
	//but needed if the table/column names are not the default 
	@JoinTable(name="employee_region",
    	joinColumns= @JoinColumn(name="employee_id", referencedColumnName="id"),
        inverseJoinColumns= @JoinColumn(name="region_id", referencedColumnName="id")
    )
	private List<Region> region;

	public Employee() {
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

	public int getEmployer_id() {
		return employer_id;
	}

	public void setEmployer_id(int employer_id) {
		this.employer_id = employer_id;
	}

	public List<Region> getRegion() {
		return region;
	}

	public void setRegion(List<Region> region) {
		this.region = region;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}