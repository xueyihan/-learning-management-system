package com.example.study.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Admin;
import com.example.study.entities.Student;


@Repository
public class StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public Student getStudentByStudentId(String studentId)
	{
		String hql = "from Student s where s.studentId=?";
		Query query = getSession().createQuery(hql).setString(0, studentId);
		return (Student) query.uniqueResult();
	}
	
	public boolean validateStudent(String username, String password)
	{
		String hql = "from Student s where s.studentId=?";
		Query query = getSession().createQuery(hql).setString(0, username);
		Student student = (Student) query.uniqueResult();
		if(student == null)
		{
			return false;
		}
		else
		{
			if(student.getStudentPassword().equals(password))
			{
				return true; 
			}
			else {
				return false;
			}
		}
	}
}
