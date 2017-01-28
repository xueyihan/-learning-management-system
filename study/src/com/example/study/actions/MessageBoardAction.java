package com.example.study.actions;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.CourseDAO;
import com.example.study.daos.MessageBoardDAO;
import com.example.study.entities.Course;
import com.example.study.entities.MessageBoard;
import com.example.study.entities.SubmitHomework;
import com.mysql.fabric.xmlrpc.base.Data;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/messageBoard")
public class MessageBoardAction extends ActionSupport{
	@Autowired
	CourseDAO courseDAO;
	@Autowired
	MessageBoardDAO messageBoardDAO;
	
	//addMessage
	String username;
	Integer identity;
	String content;
	Integer courseId;
	
	//·µ»ØJson
	Map<String, Object> data = new HashMap<String, Object>();
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setIdentity(Integer identity) {
		this.identity = identity;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}


	@Action(value="addMessage",results=@Result(type="json"))
	public String addMessage(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Course course = courseDAO.getCourseByCourseId(courseId);
		Timestamp time = new Timestamp(new Date().getTime());
		session.setAttribute("latestTime", time);
		MessageBoard messageBoard = new MessageBoard(course, username, identity, content, time);
		messageBoardDAO.addMessageBoard(messageBoard);
		data.put("messageBoard", messageBoard);
		
		return SUCCESS;
	}
	@Action(value="getAllMessageBoardsByCourseId",results=@Result(type="json"))
	public String allMessageBoardsByCourseId(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		List<MessageBoard> messageBoards = messageBoardDAO.getAllMessageBoardsByCourseId(courseId);
		if(messageBoards != null)
		{
			session.setAttribute("latestTime", messageBoards.get(0).getTime());
		}
		data.put("messageBoards", messageBoards);
		return SUCCESS;
	}
	@Action(value="getNewMessageBoardsByCourseId",results=@Result(type="json"))
	public String newMessageBoardsByCourseId(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		Timestamp timestamp = (Timestamp) session.getAttribute("latestTime");
		List<MessageBoard> newMessageBoards = messageBoardDAO.getNewMessageBoardsByCourseId(courseId, timestamp);
		if(newMessageBoards.size() > 0)
		{
			session.setAttribute("latestTime", newMessageBoards.get(0).getTime());
		}
		data.put("newMessageBoards", newMessageBoards);
		return SUCCESS;
	}
}
