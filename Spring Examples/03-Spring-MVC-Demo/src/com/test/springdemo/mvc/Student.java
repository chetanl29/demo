package com.test.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private String[] operatingSystems;
	
	private Map<String,String> countryOptions;//If we want to populate Country Options in Student Form
	
	private Map<String,String> favouriteLanguageOptions;
	
	public Student() {
		countryOptions = new LinkedHashMap<String,String>();
		countryOptions.put("BR", "BRAZIL");
		countryOptions.put("IND", "INDIA");
		countryOptions.put("GER", "GERMANY");
		countryOptions.put("FR", "FRANCE");
		countryOptions.put("US", "United States of America");
		
		favouriteLanguageOptions = new LinkedHashMap<String,String>();
		favouriteLanguageOptions.put("JAVA", "JAVA");
		favouriteLanguageOptions.put("PHP", "PHP");
		favouriteLanguageOptions.put("RUBY", "RUBY");
		favouriteLanguageOptions.put("C#", "C#");
		favouriteLanguageOptions.put("C", "C");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public Map<String, String> getFavouriteLanguageOptions() {
		return favouriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}	
	
	

}
