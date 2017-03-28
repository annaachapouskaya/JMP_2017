package com.achapouskaya.company.staff;

import java.util.Set;

public class Manager extends Employee {

	private static final long serialVersionUID = 7495941687459143692L;
	
	private String type;
	private Set<Employee> employees;
	private String projectName;
	
	public Manager() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Override
	public String toString() {
		return "Manager [type=" + type + ", employees=" + employees + ", projectName=" + projectName + "]";
	}

}
