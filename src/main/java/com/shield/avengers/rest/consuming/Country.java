package com.shield.avengers.rest.consuming;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	private String name;
	private String[] altSpellings;
	private String[] topLevelDomain;
	private String[] callingCodes;
	private String capital;
	private String region;
	private String subregion;
	private long population;
	private double[] latlng;
	private String[] timezones;
	private double area;
	private String[] borders;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getAltSpellings() {
		return altSpellings;
	}

	public void setAltSpellings(String[] altSpellings) {
		this.altSpellings = altSpellings;
	}

	public String[] getTopLevelDomain() {
		return topLevelDomain;
	}

	public void setTopLevelDomain(String[] topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public String[] getCallingCodes() {
		return callingCodes;
	}

	public void setCallingCodes(String[] callingCodes) {
		this.callingCodes = callingCodes;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubregion() {
		return subregion;
	}

	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public double[] getLatlng() {
		return latlng;
	}

	public void setLatlng(double[] latlng) {
		this.latlng = latlng;
	}

	public String[] getTimezones() {
		return timezones;
	}

	public void setTimezones(String[] timezones) {
		this.timezones = timezones;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public String[] getBorders() {
		return borders;
	}

	public void setBorders(String[] borders) {
		this.borders = borders;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", altSpellings=" + Arrays.toString(altSpellings) + ", topLevelDomain="
				+ Arrays.toString(topLevelDomain) + ", callingCodes=" + Arrays.toString(callingCodes) + ", capital="
				+ capital + ", region=" + region + ", subregion=" + subregion + ", population=" + population
				+ ", latlng=" + Arrays.toString(latlng) + ", timezones=" + timezones.toString() + ", area=" + area
				+ ", borders=" + Arrays.toString(borders) + "]";
	}

}
