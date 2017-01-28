package com.example.study.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Course;
import com.example.study.entities.Term;


@Repository
public class CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	//获取当前学期的所有课程
	public List<Course> getAllCoursesByTermId(Integer termId)
	{
		String hql = "from Course c where c.term.termId=?";
		Query query = getSession().createQuery(hql).setInteger(0, termId);
		return query.list();
	}
	public void addCourse(Course course)
	{
		getSession().save(course);
	}
	//根据CourseId获取课程
	public Course getCourseByCourseId(Integer courseId)
	{
		String hql = "from Course c where c.courseId=?";
		Query query = getSession().createQuery(hql).setInteger(0, courseId);
		return (Course) query.uniqueResult();
	}
	//根据TeacherId获取教师
	public List<Course> getCoursesByTeacherId(String teacherId)
	{
		String hql = "from Course c where c.teacher.teacherId=?";
		Query query = getSession().createQuery(hql).setString(0, teacherId);
		return query.list();
	}
}
