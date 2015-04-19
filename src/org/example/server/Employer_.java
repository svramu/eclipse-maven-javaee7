package org.example.server;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-04-17T21:16:54.150+0530")
@StaticMetamodel(Employer.class)
public class Employer_ {
	public static volatile SingularAttribute<Employer, Integer> id;
	public static volatile SingularAttribute<Employer, String> name;
	public static volatile ListAttribute<Employer, Employee> employees;
}
