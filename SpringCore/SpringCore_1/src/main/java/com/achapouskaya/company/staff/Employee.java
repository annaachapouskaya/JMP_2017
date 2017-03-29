package com.achapouskaya.company.staff;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import com.achapouskaya.company.staff.skillmatrix.JobFunction;
import com.achapouskaya.company.staff.skillmatrix.LanguageLevel;

public class Employee implements Serializable {

	private static final long serialVersionUID = -1151523942528068575L;
	
	private String name;
	private JobFunction jobFunction;
	private Date birthDate;
	private int age;
	private LanguageLevel englishLevel;
	private int level;
	
	public Employee() {
		super();
	}
	
	public void hire() {
		this.age = this.calculateAge();
		if (this.englishLevel == null) {
			this.englishLevel = LanguageLevel.UNDEFINED;
		}
		System.out.println("Employee " + this.name + " was hired");
	}
	
	public void fire() {
		System.out.println("Employee " + this.name + " was fired");
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
	
	public int calculateAge() {
		LocalDate today = LocalDate.now();
		LocalDate localBirthDate =  this.birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
		 
		Period agePeriod = Period.between(localBirthDate, today);
		return agePeriod.getYears();
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", jobFunction=" + jobFunction + ", birthDate=" + birthDate
				+ ", age=" + age + ", englishLevel=" + englishLevel + ", level=" + level + "]";
	}
}
