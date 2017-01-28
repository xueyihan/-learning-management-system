package com.example.study.actions;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.HomeworkDAO;
import com.example.study.daos.SubmitHomeworkDAO;
import com.example.study.entities.Course;
import com.example.study.entities.Homework;
import com.example.study.entities.Student;
import com.example.study.entities.StudentCourse;
import com.example.study.entities.SubmitHomework;
import com.example.study.entities.Term;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/course")
public class CourseAction extends ActionSupport{
	
	@Autowired
	HomeworkDAO homeworkDAO;
	@Autowired
	SubmitHomeworkDAO submitHomeworkDAO;
	//getHomeworkByHomeworkId getSHBySIdAndHId
	private Integer homeworkId;
	//getSHBySIdAndHId
	private String studentId;
	
	
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}


	//·µ»ØµÄJson
	private Map<String, Object> data = new HashMap<String, Object>();
	
	
	public Map<String, Object> getData() {
		return data;
	}
	
	
	@Action(value="getHomeworkByHomeworkId",results=@Result(type="json"))
	public String homeworkByHomeworkId(){
		Homework homework = homeworkDAO.getHomeworkByHomeworkId(homeworkId);
		data.put("homework", homework);
		return SUCCESS;
	}
	
	@Action(value="getSHBySIdAndHId",results=@Result(type="json"))
	public String SHBySIdAndHId(){
		SubmitHomework submitHomework = submitHomeworkDAO.getSHBySIdAndHId(studentId, homeworkId);
		data.put("submitHomework", submitHomework);
		return SUCCESS;
	}
}
