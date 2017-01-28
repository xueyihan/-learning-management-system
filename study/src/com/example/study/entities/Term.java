package com.example.study.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Term entity. @author MyEclipse Persistence Tools
 */

public class Term implements java.io.Serializable {

	// Fields

	private Integer termId;
	private String year;
	private String season;
	private String week;

	// Constructors

	/** default constructor */
	public Term() {
	}

	/** full constructor */
	public Term(String year, String season, String week) {
		this.year = year;
		this.season = season;
		this.week = week;
	}
	// Property accessors

	public Integer getTermId() {
		return this.termId;
	}

	public void setTermId(Integer termId) {
		this.termId = termId;
	}

	public String getYear() {
		return this.year;
	}

	@Override
	public String toString() {
		return "Term [termId=" + termId + ", year=" + year + ", season="
				+ season + ", week=" + week + "]";
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSeason() {
		return this.season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}


}