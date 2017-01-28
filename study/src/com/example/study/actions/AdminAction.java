package com.example.study.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.CourseDAO;
import com.example.study.daos.StudentCourseDAO;
import com.example.study.daos.StudentDAO;
import com.example.study.daos.TeacherDAO;
import com.example.study.daos.TermDAO;
import com.example.study.entities.Course;
import com.example.study.entities.Student;
import com.example.study.entities.StudentCourse;
import com.example.study.entities.Teacher;
import com.example.study.entities.Term;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/admin")
public class AdminAction extends ActionSupport{
	
	@Autowired
	private TermDAO termDAO;
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	@Autowired 
	private StudentDAO studentDAO;
	@Autowired
	private StudentCourseDAO studentCourseDAO;
	//addTerm
	private String year;
	private String season;
	private String week;
	//getAllCoursesByTermId addCourseByTermId
	private Integer termId;
	//addCourseByTermId
	private String courseName;
	private String courseType;
	private String teacherId;
	private String teacherName;
	private String courseInfo;
	//getAllStudentsByCourseId addStudentCourse
	private Integer courseId;
	//addStudentCourse
	private String studentId;
	
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public void setCourseId(Integer courseId)
	{
		this.courseId = courseId;
	}
	
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setCourseInfo(String courseInfo) {
		this.courseInfo = courseInfo;
	}

	public void setTermId(Integer termId)
	{
		this.termId = termId;
	}
	
	public void setYear(String year) {
		this.year = year;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	private Map<String, Object> data = new HashMap<String, Object>();
	
	public Map<String, Object> getData()
	{
		return data;
	}
	
	@Action(value="getAllTerms",results=@Result(type="json"))
	public String allTerms(){
		List<Term> terms = termDAO.getAllTerms();
		data.put("terms", terms);
		return SUCCESS;
	}
	
	@Action(value="addTerm",results=@Result(type="json"))
	public String addTerm(){
		Term newTerm = new Term(year,season,week);
		termDAO.addTerm(newTerm);
		data.put("term", newTerm);
		return SUCCESS;
	}
	
	@Action(value="getAllCoursesByTermId",results=@Result(type="json"))
	public String allCoursesByTermId(){
		List<Course> courses = courseDAO.getAllCoursesByTermId(termId);
		data.put("courses", courses );
		return SUCCESS;
	}
	
	@Action(value="addCourseByTermId",results=@Result(type="json"))
	public String addCourseByTermId(){
		Term term = termDAO.getTermByTermId(termId);
		Teacher teacher = teacherDAO.getTeacherByTeacherId(teacherId);
		Course course = new Course(term, teacher, courseName, courseType, teacherName, courseInfo);
		courseDAO.addCourse(course);
		data.put("course", course);
		return SUCCESS;
	}
	
	@Action(value="getAllStudentsByCourseId",results=@Result(type="json"))
	public String allStudentsByCourseId(){
		List<Student> students = studentCourseDAO.getAllStudents(courseId);
		data.put("students", students);
		return SUCCESS;
	}
	
	@Action(value="addStudentCourse",results=@Result(type="json"))
	public String addStudentCourse(){
		Student student = studentDAO.getStudentByStudentId(studentId);
		Course course = courseDAO.getCourseByCourseId(courseId);
		Term term = course.getTerm();
		StudentCourse studentCourse = new StudentCourse(term, student, course);
		studentCourseDAO.addStudent(studentCourse);
		data.put("studentCourse", studentCourse);
		return SUCCESS;
	}
}
