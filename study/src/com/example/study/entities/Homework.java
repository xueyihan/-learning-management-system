package com.example.study.entities;

import java.sql.Timestamp;

/**
 * Homework entity. @author MyEclipse Persistence Tools
 */

public class Homework implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private Integer homeworkId;
	private Course course;
	private String content;
	private Timestamp deadline;
	private String resourceLocation;
	private String homeworkName;
	public String getHomeworkName() {
		return homeworkName;
	}

	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}


	// Constructors

	/** default constructor */
	public Homework() {
	}

	/** minimal constructor */
	public Homework(Course course) {
		this.course = course;
	}

	

	public Homework(Course course, String content, Timestamp deadline,
			String resourceLocation, String homeworkName) {
		this.course = course;
		this.content = content;
		this.deadline = deadline;
		this.resourceLocation = resourceLocation;
		this.homeworkName = homeworkName;
	}

	// Property accessors

	public String getResourceLocation() {
		return resourceLocation;
	}

	public void setResourceLocation(String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}

	public Integer getHomeworkId() {
		return this.homeworkId;
	}

	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Timestamp deadline) {
		this.deadline = deadline;
	}


}