package com.example.study.daos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Term;


@Repository
public class TermDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	//获取所有学期信息
	public List<Term> getAllTerms()
	{
		String hql = "from Term";
		Query query = getSession().createQuery(hql);
		return (List<Term>)query.list();
	}
	//添加一个学期
	public void addTerm(Term term)
	{
		getSession().save(term);
	}
	//根据学期号获取学期信息
	public Term getTermByTermId(Integer termId)
	{
		String hql = "from Term t where t.termId=?";
		Query query = getSession().createQuery(hql).setInteger(0, termId);
		return (Term) query.uniqueResult();
	}
}
