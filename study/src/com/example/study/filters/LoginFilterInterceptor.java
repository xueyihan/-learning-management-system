package com.example.study.filters;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginFilterInterceptor extends MethodFilterInterceptor {

	/*@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("get in LoginFilterInterceptor");
		HttpSession session= ServletActionContext.getRequest().getSession();
		if(session.getAttribute("username")!=null){
			return arg0.invoke();
		}else{
			return Action.LOGIN;
		}
	}*/

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("get in LoginFilterInterceptor");
//		HttpSession session= ServletActionContext.getRequest().getSession();
//		if(session.getAttribute("username")!=null){
			return arg0.invoke();
//		}else{
//			return Action.LOGIN;
//		}
	}

}
