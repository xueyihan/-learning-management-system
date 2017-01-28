package com.example.study.entities;

/**
 * SubmitHomework entity. @author MyEclipse Persistence Tools
 */

public class SubmitHomework implements java.io.Serializable {

	// Fields

	private Integer shId;
	private Homework homework;
	private Student student;
	private String filePath;
	private Integer score;

	// Constructors

	/** default constructor */
	public SubmitHomework() {
	}

	/** minimal constructor */
	public SubmitHomework(Homework homework, Student student) {
		this.homework = homework;
		this.student = student;
	}

	/** full constructor */
	public SubmitHomework(Homework homework, Student student, String filePath,
			Integer score) {
		this.homework = homework;
		this.student = student;
		this.filePath = filePath;
		this.score = score;
	}

	// Property accessors

	public Integer getShId() {
		return this.shId;
	}

	public void setShId(Integer shId) {
		this.shId = shId;
	}

	public Homework getHomework() {
		return this.homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getFilePath() {
		return this.filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}