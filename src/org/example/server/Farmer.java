package org.example.server;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the farmer database table.
 * 
 */
@Entity
@Table(name="farmer")
@NamedQuery(name="Farmer.findAll", query="SELECT f FROM Farmer f")
public class Farmer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	public Farmer() {
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