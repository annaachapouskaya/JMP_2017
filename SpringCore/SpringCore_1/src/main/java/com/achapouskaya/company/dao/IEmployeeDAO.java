package com.achapouskaya.company.dao;

import java.util.List;

import com.achapouskaya.company.staff.Employee;

public interface IEmployeeDAO<Entity extends Employee> {
	
	public String create(Entity employee); 
	public Entity get(String id);
	public List<Entity> getAll();
	public boolean update(Entity employee);
	public boolean delete(String id);
	
}
