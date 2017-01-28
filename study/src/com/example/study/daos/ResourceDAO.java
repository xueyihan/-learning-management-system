package com.example.study.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Resource;

@Repository
public class ResourceDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public List<Resource> getResourcesByCourseId(Integer courseId)
	{
		String hql = "from Resource r where r.course.courseId=?";
		Query query = getSession().createQuery(hql).setInteger(0, courseId);
		return query.list();
	}
	public void addResource(Resource resource)
	{
		getSession().save(resource);
		
	}
}
