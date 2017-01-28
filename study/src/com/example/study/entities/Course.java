package com.example.study.entities;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private Integer courseId;//
	private Term term;       // 
	private Teacher teacher; //
	private String courseName;//
	private String courseType;//
	private String teacherName;//
	private String courseInfo;//

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(Term term, Teacher teacher, String courseName,
			String courseType, String teacherName, String courseInfo) {
		this.term = term;
		this.teacher = teacher;
		this.courseName = courseName;
		this.courseType = courseType;
		this.teacherName = teacherName;
		this.courseInfo = courseInfo;
	}

	// Property accessors

	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Term getTerm() {
		return this.term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return this.courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseInfo() {
		return this.courseInfo;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}


}