package com.epam.achapouskaya.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employee implements Serializable{
	
	private static final long serialVersionUID = 2885499126995707264L;
	
	@XmlElement( required = true )
	private String id;
	
	@XmlElement( required = true )
	private String name;
	
	@XmlElement( required = false )
	private int salary;
	
	public Employee() {
		super();
	}
	public Employee(String id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
