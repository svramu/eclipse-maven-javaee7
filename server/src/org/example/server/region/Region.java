package org.example.server.region;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="region")
@NamedQuery(name="Region.findAll", query="SELECT e FROM Region e")
public class Region implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	public Region() {
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