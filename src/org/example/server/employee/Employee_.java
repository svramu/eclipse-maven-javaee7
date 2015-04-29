package org.example.server.employee;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.example.server.department.Department;
import org.example.server.region.Region;

@Generated(value="Dali", date="2015-04-29T09:14:47.253+0530")
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile ListAttribute<Employee, Region> region;
	public static volatile SingularAttribute<Employee, Department> department;
	public static volatile SingularAttribute<Employee, Integer> employer_id;
}
