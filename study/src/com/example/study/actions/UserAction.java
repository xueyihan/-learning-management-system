package com.example.study.actions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.AdminDAO;
import com.example.study.daos.TeacherDAO;
import com.example.study.daos.StudentDAO;
import com.example.study.daos.StudentCourseDAO;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/user")
public class UserAction extends ActionSupport {

	@Autowired
	private AdminDAO adminDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private TeacherDAO teacherDAO;
	

	private String username;
	private String password;
	private String Test;
	private Integer indentity;

	public void setIndentity(Integer indentity) {
		this.indentity = indentity;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Map<String, Object> data = new HashMap<String, Object>();

	public Map<String, Object> getData() {
		return data;
	}

	@Action(value = "login", results = @Result(type = "json"))
	public String login() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 如果是管理员登录
		if (indentity == 3) {
			boolean validate = adminDAO.validateAdmin(username, password);
			if (validate == true) {
				session.setAttribute("username", username);
				data.put("result", "success");
			} else {
				data.put("result", "fail");
			}
		} 
		else if (indentity == 1) // 学生
		{
			boolean validate = studentDAO.validateStudent(username, password);
			if (validate == true) {
				session.setAttribute("username", username);
				data.put("result", "success");
			} else {
				data.put("result", "fail");
			}
		}
		else if (indentity == 2) // 老师
		{
			boolean validate = teacherDAO.validateTeacher(username, password);
			if (validate == true) {
				session.setAttribute("username", username);
				data.put("result", "success");
			} else {
				data.put("result", "fail");
			}
		}
		return SUCCESS;
	}

	@Action(value = "logout", results = @Result(type = "json"))
	public String logout() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("username");
			data.put("result", "success");
		} catch (Exception e) {
			data.put("result", "fail");
		}
		return SUCCESS;
	}
}
