package com.example.study.entities;

/**
 * StudentCourse entity. @author MyEclipse Persistence Tools
 */

public class StudentCourse implements java.io.Serializable {

	// Fields

	private Integer scId;
	private Term term;
	private Student student;
	private Course course;

	// Constructors

	/** default constructor */
	public StudentCourse() {
		
	}

	/** full constructor */
	public StudentCourse(Term term, Student student, Course course) {
		this.term = term;
		this.student = student;
		this.course = course;
	}


	public Integer getScId() {
		return this.scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}

	public Term getTerm() {
		return this.term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}