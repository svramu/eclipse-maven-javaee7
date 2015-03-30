package org.example.server;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-03-29T21:13:54.960+0530")
@StaticMetamodel(Person.class)
public class Person_ {
	public static volatile SingularAttribute<Person, Integer> id;
	public static volatile SingularAttribute<Person, String> passhash;
	public static volatile SingularAttribute<Person, String> salt;
	public static volatile SingularAttribute<Person, String> username;
}
