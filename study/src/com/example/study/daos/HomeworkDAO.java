package com.example.study.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Homework;

@Repository
public class HomeworkDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	//ͨ���γ�Id�õ����е���ҵ��Ϣ
	public List<Homework> getHomeworksByCourseId(Integer courseId)
	{
		String hql = "from Homework h where h.course.courseId=?";
		Query query = getSession().createQuery(hql).setInteger(0, courseId);
		return query.list();
	}
	//ͨ����ҵId�õ���ҵ��Ϣ
	public Homework getHomeworkByHomeworkId(Integer homeworkId)
	{
		String hql = "from Homework h where h.homeworkId=?";
		Query query = getSession().createQuery(hql).setInteger(0, homeworkId);
		return (Homework) query.uniqueResult();
	}
	//�����ҵ
	public void addHomework(Homework homework)
	{
		getSession().save(homework);
	}
}
