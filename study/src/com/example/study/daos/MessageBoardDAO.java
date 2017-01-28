package com.example.study.daos;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.MessageBoard;

@Repository
public class MessageBoardDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public void addMessageBoard(MessageBoard messageBoard)
	{
		getSession().save(messageBoard);
	}
	
	public List<MessageBoard> getAllMessageBoardsByCourseId(Integer courseId)
	{
		String hql = "from MessageBoard mb where mb.course.courseId=? order by mb.time desc";
		Query query = getSession().createQuery(hql).setInteger(0, courseId);
		return query.list();
	}
	
	public List<MessageBoard> getNewMessageBoardsByCourseId(Integer courseId, Timestamp timestamp)
	{
		String hql = "from MessageBoard mb where mb.course.courseId=? and mb.time>? order by mb.time desc";
		Query query = getSession().createQuery(hql).setInteger(0, courseId).setTimestamp(1, timestamp);
		return query.list();
	}
}
