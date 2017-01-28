package com.example.study.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.NewsAddress;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.study.daos.TermDAO;
import com.example.study.entities.Term;
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("mypackage")
@Namespace("/text")
public class TextAction extends ActionSupport {

	@Autowired
	private TermDAO termDAO;

	private String userName;
	private String password;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Map<String, Object> msg = new HashMap<String, Object>();

	public Map<String, Object> getMsg() {
		return msg;
	}

	@Action(value = "qwe", results = @Result(type = "json"))
	public String qwe() {
		msg.put("test1", "test1");
		msg.put("test2", "test2");
		return SUCCESS;
	}

	@Action(value = "ert", results = @Result(type = "json"))
	public String fdwd() {
		msg.put("test1", "test1");
		msg.put("test2", "test2");
		return SUCCESS;
	}
}
