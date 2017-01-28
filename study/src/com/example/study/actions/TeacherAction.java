package com.example.study.actions;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.CourseDAO;
import com.example.study.daos.HomeworkDAO;
import com.example.study.daos.SubmitHomeworkDAO;
import com.example.study.daos.TeacherDAO;
import com.example.study.entities.Course;
import com.example.study.entities.Student;
import com.example.study.entities.Homework;
import com.example.study.entities.SubmitHomework;
import com.example.study.entities.Teacher;
import com.example.study.utils.Date2Timestamp;
import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("mypackage")
@Namespace("/teacher")
public class TeacherAction extends ActionSupport{
	
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	SubmitHomeworkDAO submitHomeworkDAO;
	@Autowired
	HomeworkDAO homeworkDAO;
	@Autowired
	TeacherDAO teacherDAO;
	//getCoursesByTeacherId getTeacherByTeacherId
	String teacherId;
	//addHomework
	Integer courseId;
	String homeworkName;
	String homeworkContent;
	String time;
	String resourceLocation;
	//getSHByHomeworkId
	Integer homeworkId;
	
	public void setResourceLocation(String resourceLocation) {
		this.resourceLocation = resourceLocation;
	}
	
	public void setHomeworkId(Integer homeworkId) {
		this.homeworkId = homeworkId;
	}
	
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	public void setHomeworkName(String homeworkName) {
		this.homeworkName = homeworkName;
	}

	public void setHomeworkContent(String homeworkContent) {
		this.homeworkContent = homeworkContent;
	}

	

	public void setTime(String time) {
		this.time = time;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	//·µ»ØµÄJson
	Map<String, Object> data = new HashMap<String, Object>();
	
	public Map<String, Object> getData() {
		return data;
	}
	
	@Action(value="getCoursesByTeacherId",results=@Result(type="json"))
	public String coursesByTeacherId(){
		List<Course> courses = courseDAO.getCoursesByTeacherId(teacherId);
		data.put("courses", courses);
		return SUCCESS;
	}
	@Action(value="addHomework",results=@Result(type="json"))
	public String addHomework(){
		Course course = courseDAO.getCourseByCourseId(courseId);
		//Timestamp time = Date2Timestamp.getTimestamp(year, month, day, hour, minute, second);
		Timestamp timestamp = Timestamp.valueOf(time);
		Homework homework = new Homework(course,homeworkContent,timestamp,resourceLocation,homeworkName);
		homeworkDAO.addHomework(homework);
		data.put("homework", homework);
		return SUCCESS;
	}
	@Action(value="getSHsByHomeworkId",results=@Result(type="json"))
	public String SHsByHomeworkId(){
		List<SubmitHomework> submitHomeworks = submitHomeworkDAO.getSHsByHomeworkId(homeworkId);
		data.put("submitHomeworks", submitHomeworks);
		return SUCCESS;
	}
	
	
	@Action(value="getTeacherByTeacherId",results=@Result(type="json"))
	public String teacherByTeacherId(){
		Teacher teacher = teacherDAO.getTeacherByTeacherId(teacherId);
		data.put("teacher", teacher);
		return SUCCESS;
	}
}
