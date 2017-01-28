package com.example.study.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Student;
import com.example.study.entities.Teacher;

@Repository
public class TeacherDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	//根据teacherId得到Teacher
	public Teacher getTeacherByTeacherId(String teacherId)
	{
		String hql = "from Teacher t where t.teacherId=?";
		Query query = getSession().createQuery(hql).setString(0, teacherId);
		return (Teacher)query.uniqueResult();
	}
	//验证教师是否合法
	public boolean validateTeacher(String username, String password)
	{
		String hql = "from Teacher t where t.teacherId=?";
		Query query = getSession().createQuery(hql).setString(0, username);
		Teacher teacher = (Teacher) query.uniqueResult();
		if(teacher == null)
		{
			return false;
		}
		else
		{
			if(teacher.getTeacherPassword().equals(password))
			{
				return true; 
			}
			else {
				return false;
			}
		}
	}
}
