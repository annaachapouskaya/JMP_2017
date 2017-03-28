package com.achapouskaya.company.staff;

import java.util.Map;

public class SoftwareEngineer {
	
	private String mainLanguage;
	private Map<String, Integer> frameworksExpirence;
	
	public SoftwareEngineer() {
		super();
	}

	public String getMainLanguage() {
		return mainLanguage;
	}

	public void setMainLanguage(String mainLanguage) {
		this.mainLanguage = mainLanguage;
	}

	public Map<String, Integer> getFrameworksExpirence() {
		return frameworksExpirence;
	}

	public void setFrameworksExpirence(Map<String, Integer> frameworksExpirence) {
		this.frameworksExpirence = frameworksExpirence;
	}

	@Override
	public String toString() {
		return "SoftwareEngineer [mainLanguage=" + mainLanguage + ", frameworksExpirence=" + frameworksExpirence + "]";
	}
}
