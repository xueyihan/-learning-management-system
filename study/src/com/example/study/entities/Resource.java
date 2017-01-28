package com.example.study.entities;

import java.sql.Date;


/**
 * Resource entity. @author MyEclipse Persistence Tools
 */

public class Resource implements java.io.Serializable {

	// Fields

	private Integer resourceId;
	private Course course;
	private String resourceName;
	private Date resourceDate;
	private String resourcePath;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** full constructor */
	public Resource(Course course, String resourceName, Date resourceDate,
			String resourcePath) {
		this.course = course;
		this.resourceName = resourceName;
		this.resourceDate = resourceDate;
		this.resourcePath = resourcePath;
	}

	// Property accessors

	public Integer getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Date getResourceDate() {
		return resourceDate;
	}
	public void setResourceDate(Date resourceDate) {
		this.resourceDate = resourceDate;
	}
	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

}