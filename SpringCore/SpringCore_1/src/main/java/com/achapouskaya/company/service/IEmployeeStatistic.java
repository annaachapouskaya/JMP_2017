package com.achapouskaya.company.service;

import java.util.Map;
import java.util.TreeMap;

import com.achapouskaya.company.staff.Employee;
import com.achapouskaya.company.staff.skillmatrix.LanguageLevel;

public abstract class IEmployeeStatistic {

	private Map<String, Employee> allEmployees;
	

	private int averageAge;
	private Map <LanguageLevel, Integer> employeesNumbByEngLevel; 
	
	public abstract void init();
	
	public Map<String, Employee> getAllEmployees() {
		return allEmployees;
	}

	public void setAllEmployees(Map<String, Employee> allEmployees) {
		this.allEmployees = allEmployees;
	}

	public int getAverageAge() {
		return averageAge;
	}

	public void setAverageAge(int averageAge) {
		this.averageAge = averageAge;
	}

	public Map<LanguageLevel, Integer> getEmployeesNumbByEngLevel() {
		return employeesNumbByEngLevel;
	}

	public void setEmployeesNumbByEngLevel(Map<LanguageLevel, Integer> employeesNumbByEngLevel) {
		this.employeesNumbByEngLevel = employeesNumbByEngLevel;
	}
	
	public void initAverageAge() {
		this.averageAge = calculateAverageAge();
	}
	
	public void initEmployeesNumbByEngLevel() {
		this.employeesNumbByEngLevel = calculateEmployeesNumbByEngLevel();
	}
	
	public int calculateAverageAge() {
		long ageSum = 0;
		for (Map.Entry<String, Employee> employee : this.allEmployees.entrySet()) {
			ageSum += employee.getValue().getAge();
		}
		return (int) (ageSum / allEmployees.size());
	}
	
	public Map<LanguageLevel, Integer> calculateEmployeesNumbByEngLevel() {
		Map<LanguageLevel, Integer> employeesNumbByEngLevel =
				new TreeMap<LanguageLevel, Integer>();
		
		employeesNumbByEngLevel.put(LanguageLevel.A1, 0);
		employeesNumbByEngLevel.put(LanguageLevel.A2, 0);
		employeesNumbByEngLevel.put(LanguageLevel.B1, 0);
		employeesNumbByEngLevel.put(LanguageLevel.B2, 0);
		employeesNumbByEngLevel.put(LanguageLevel.C1, 0);
		employeesNumbByEngLevel.put(LanguageLevel.C2, 0);
		employeesNumbByEngLevel.put(LanguageLevel.UNDEFINED, 0);

		
		for (Map.Entry<String, Employee> employee : this.allEmployees.entrySet()) {
			if (employee.getValue().getEnglishLevel() == null) {
				employeesNumbByEngLevel.put(LanguageLevel.UNDEFINED,
						employeesNumbByEngLevel.get(LanguageLevel.UNDEFINED) + 1);
			} else {
				switch(employee.getValue().getEnglishLevel()) {
				case A1: 
					employeesNumbByEngLevel.put(LanguageLevel.A1,
							employeesNumbByEngLevel.get(LanguageLevel.A1) + 1);
	                break;
	            case A2:
	            	employeesNumbByEngLevel.put(LanguageLevel.A2,
							employeesNumbByEngLevel.get(LanguageLevel.A2) + 1);
	                break;
	            case B1: 
					employeesNumbByEngLevel.put(LanguageLevel.B1,
							employeesNumbByEngLevel.get(LanguageLevel.B1) + 1);
	                break;
	            case B2:
	            	employeesNumbByEngLevel.put(LanguageLevel.B2,
							employeesNumbByEngLevel.get(LanguageLevel.B2) + 1);
	                break;
	            case C1: 
					employeesNumbByEngLevel.put(LanguageLevel.C1,
							employeesNumbByEngLevel.get(LanguageLevel.C1) + 1);
	                break;
	            case C2:
	            	employeesNumbByEngLevel.put(LanguageLevel.C2,
							employeesNumbByEngLevel.get(LanguageLevel.C2) + 1);
	                break;
	            case UNDEFINED:
	            	employeesNumbByEngLevel.put(LanguageLevel.UNDEFINED,
							employeesNumbByEngLevel.get(LanguageLevel.UNDEFINED) + 1);
	                break;
				}
			}
		}
		return employeesNumbByEngLevel;
	}

	@Override
	public String toString() {
		return "IEmployeeStatistic [averageAge=" + averageAge
				+ ", employeesNumbByEngLevel=" + employeesNumbByEngLevel + "]";
	}
	
}
