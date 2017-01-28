package com.example.study.entities;

public class MyFile {
	String fileName;
	String createDate;
	public MyFile(String fileName, String createDate,Integer courseId) {
		super();
		this.fileName = fileName;
		this.createDate = createDate;
		this.courseId = courseId;
	}
	Integer courseId;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
