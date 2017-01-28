package com.example.study.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.SubmitHomework;

@Repository
public class SubmitHomeworkDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public SubmitHomework getSHBySIdAndHId(String studentId, Integer homeworkId)
	{
		String hql = "from SubmitHomework sh where sh.student.studentId=? and sh.homework.homeworkId=?";
		Query query = getSession().createQuery(hql).setString(0, studentId).setInteger(1, homeworkId);
		return (SubmitHomework) query.uniqueResult();
	}
	
	public List<SubmitHomework> getSHsByHomeworkId(Integer homeworkId)
	{
		String hql = "from SubmitHomework sh where sh.homework.homeworkId=?";
		Query query = getSession().createQuery(hql).setInteger(0, homeworkId);
		return query.list();
	}
	
	public void addSubmitHomework(SubmitHomework submitHomework)
	{
		getSession().save(submitHomework);
	}
	
	public void updateSubmitHomework(SubmitHomework submitHomework)
	{
		getSession().update(submitHomework);
	}
}
