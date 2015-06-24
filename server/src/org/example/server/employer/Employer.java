package org.example.server.employer;

import java.io.Serializable;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

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
	
}