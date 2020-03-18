package com.manny.springdemo.mvc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String favoriteLanguage;
	private LinkedHashMap<String, String> countryOptions;
	private List<String> languageList;
	private String[] operatingSystems;
	
	public Student() {
		
	// populate countries
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("FR", "France");
		countryOptions.put("DE", "Germany");
		countryOptions.put("IN", "India");
		countryOptions.put("GH", "Ghana");
		
		languageList = new ArrayList<>();
		languageList.add("Java ");
		languageList.add("Python ");
		languageList.add("PHP ");
		languageList.add("Ruby ");
		languageList.add("C# ");

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



	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}
	
	

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public List<String> getLanguageList() {
		return languageList;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	


}
