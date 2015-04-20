package org.example.server;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

//https://answers.atlassian.com/questions/292925/serialize-a-pojo-to-json-in-a-rest-module
@JsonAutoDetect
public class EmploymentDTO {
	@JsonProperty
	String employer_name;
	@JsonProperty
	int employee_id;
	@JsonProperty
	String employee_name;
	
	public EmploymentDTO(String employer_name,
			int employee_id, String employee_name) {
		super();
		this.employer_name = employer_name;
		this.employee_id = employee_id;
		this.employee_name = employee_name;
	}
}
