package org.example.server;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-04-17T17:26:12.002+0530")
@StaticMetamodel(Person.class)
public class Person_ {
	public static volatile SingularAttribute<Person, Integer> id;
	public static volatile SingularAttribute<Person, String> passhash;
	public static volatile SingularAttribute<Person, String> salt;
	public static volatile SingularAttribute<Person, String> username;
}
