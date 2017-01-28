package com.example.study.actions;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.CourseDAO;
import com.example.study.daos.ResourceDAO;
import com.example.study.entities.Course;
import com.example.study.entities.Resource;
import com.example.study.entities.Teacher;
import com.example.study.entities.Term;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/resource")
public class ResourceAction extends ActionSupport{
	
	@Autowired 
	ResourceDAO resourceDAO;
	@Autowired
	CourseDAO courseDAO;
	
	//getResourceByCourseId addResource
	Integer courseId;
	//addResource
	String resourceName;
	String resourcePath;
	
	//·µ»ØJson 
	Map<String, Object> data = new HashMap<String, Object>();
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	@Action(value="getResourceByCourseId",results=@Result(type="json"))
	public String resourceByCourseId(){
		List<Resource> resources = resourceDAO.getResourcesByCourseId(courseId);
		data.put("resources", resources);
		return SUCCESS;
	}
	
	@Action(value="addResource",results=@Result(type="json"))
	public String addResource(){
		Course course = courseDAO.getCourseByCourseId(courseId);
		Date resourceDate = new Date(new java.util.Date().getTime());
		Resource resource = new Resource(course, resourceName, resourceDate, resourcePath);
		resourceDAO.addResource(resource);
		data.put("resource", resource);
		return SUCCESS;
	}
	
}
