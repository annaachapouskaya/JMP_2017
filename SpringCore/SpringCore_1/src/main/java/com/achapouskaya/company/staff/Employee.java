package com.achapouskaya.company.staff;

import java.io.Serializable;
import java.util.Date;

import com.achapouskaya.company.staff.skillmatrix.JobFunction;
import com.achapouskaya.company.staff.skillmatrix.LanguageLevel;

public class Employee implements Serializable {

	private static final long serialVersionUID = -1151523942528068575L;
	
	private String id;
	private String name;
	private JobFunction jobFunction;
	private Date birthDate;
	private int age;
	private LanguageLevel englishLevel;
	private int level;
	
	public Employee() {
		super();
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
	
	public JobFunction getJobFunction() {
		return jobFunction;
	}
	public void setJobFunction(JobFunction jobFunction) {
		this.jobFunction = jobFunction;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public LanguageLevel getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(LanguageLevel englishLevel) {
		this.englishLevel = englishLevel;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", jobFunction=" + jobFunction + ", birthDate=" + birthDate
				+ ", age=" + age + ", englishLevel=" + englishLevel + ", level=" + level + "]";
	}
}
