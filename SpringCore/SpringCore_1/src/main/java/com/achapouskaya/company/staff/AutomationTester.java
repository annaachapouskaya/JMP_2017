package com.achapouskaya.company.staff;

public class AutomationTester extends Employee {
	
	private static final long serialVersionUID = -3449842821541931666L;
	
	private String language;
	private String framework;
	
	public AutomationTester() {
		super();
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	@Override
	public String toString() {
		return "AutomationTester [language=" + language + ", framework=" + framework + "]";
	}
	
	
}
