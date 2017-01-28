package com.example.study.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.CourseDAO;
import com.example.study.daos.HomeworkDAO;
import com.example.study.daos.StudentCourseDAO;
import com.example.study.daos.StudentDAO;
import com.example.study.daos.SubmitHomeworkDAO;
import com.example.study.entities.Course;
import com.example.study.entities.Homework;
import com.example.study.entities.Student;
import com.example.study.entities.SubmitHomework;
import com.mysql.fabric.xmlrpc.base.Data;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/student")
public class StudentAction extends ActionSupport{
	
	@Autowired
	StudentCourseDAO studentCourseDAO;
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	HomeworkDAO homeworkDAO;
	@Autowired
	StudentDAO studentDAO;
	@Autowired 
	SubmitHomeworkDAO submitHomeworkDAO;
	
	//·µ»ØµÄJson
	Map<String, Object> data = new HashMap<String, Object>();
	
	//getCoursesByStudentId addSubmitHomework
	String studentId;
	//getCourseByCourseId
	Integer courseId;
	//addSubmitHomework
	Integer homeworkId;
	String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Action(value = "getCoursesByStudentId", results = @Result(type = "json"))
	public String coursesByStudentId() {
		
		Set<Course> courses = studentCourseDAO.getCoursesByStudentId(studentId);
		data.put("courses", courses);
		return SUCCESS;
	}
	
	@Action(value = "getCourseByCourseId", results = @Result(type = "json"))
	public String courseByCourseId() {
		Course course = courseDAO.getCourseByCourseId(courseId);
		data.put("course", course);
		return SUCCESS;
	}
	@Action(value = "getHomeworksByCourseId", results = @Result(type = "json"))
	public String homeworksByCourseId() {
		List<Homework> homeworks = homeworkDAO.getHomeworksByCourseId(courseId);
		data.put("homeworks", homeworks);
		return SUCCESS;
	}
	@Action(value = "getStudentByStudentId", results = @Result(type = "json"))
	public String studentByStudentId() {
		Student student = studentDAO.getStudentByStudentId(studentId);
		data.put("student", student);
		return SUCCESS;
	}
	@Action(value = "addSubmitHomework", results = @Result(type = "json"))
	public String addSubmitHomework() {
		Student student = studentDAO.getStudentByStudentId(studentId);
		Homework homework = homeworkDAO.getHomeworkByHomeworkId(homeworkId);
		SubmitHomework submitHomework = submitHomeworkDAO.getSHBySIdAndHId(studentId, homeworkId);
		if(submitHomework != null)
		{
			submitHomework.setFilePath(filePath);
			submitHomework.setHomework(homework);
			submitHomework.setStudent(student);
			submitHomeworkDAO.updateSubmitHomework(submitHomework);
		}
		else
		{
			submitHomework = new SubmitHomework(homework, student,filePath,null);
			submitHomeworkDAO.addSubmitHomework(submitHomework);
		}
		data.put("submitHomework", submitHomework);
		return SUCCESS;
	}
	@Action(value="getSHByHomeworkIdStudentId",results=@Result(type="json"))
	public String SHByHomeworkIdStudentId(){
		SubmitHomework submitHomework = submitHomeworkDAO.getSHBySIdAndHId(studentId, homeworkId);
		data.put("submitHomework", submitHomework);
		return SUCCESS;
	}
}
