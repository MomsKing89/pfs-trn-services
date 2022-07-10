package com.pfs.orchestrationservice;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "EmployeeId", "EmployeeName", "EmployeeDesignation", "EmployeeExperience" })
public class EmployeeVO {

	@JsonProperty("EmployeeId")
	private String employeeId;
	@JsonProperty("EmployeeName")
	private String employeeName;
	@JsonProperty("EmployeeDesignation")
	private String empDesignation;
	@JsonProperty("EmployeeExperience")
	private Integer empExperience;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("EmployeeName")
	public String getEmployeeName() {
		return employeeName;
	}

	@JsonProperty("EmployeeId")
	public String getEmployeeId() {
		return employeeId;
	}

	@JsonProperty("EmployeeId")
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@JsonProperty("EmployeeName")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@JsonProperty("EmployeeDesignation")
	public String getEmpDesignation() {
		return empDesignation;
	}

	@JsonProperty("EmployeeDesignation")
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}

	@JsonProperty("EmployeeExperience")
	public Integer getEmpExperience() {
		return empExperience;
	}

	@JsonProperty("EmployeeExperience")
	public void setEmpExperience(Integer empExperience) {
		this.empExperience = empExperience;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
