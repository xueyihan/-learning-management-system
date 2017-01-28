package com.example.study.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.study.entities.Admin;

@Repository
public class AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public boolean validateAdmin(String username,String password)
	{
		String hql = "from Admin a where a.adminId=?";
		Query query = getSession().createQuery(hql).setString(0, username);
		Admin admin = (Admin) query.uniqueResult();
		if(admin == null)
		{
			return false;
		}
		else
		{
			if(admin.getAdminPassword().equals(password))
			{
				return true; 
			}
			else {
				return false;
			}
		}
	}
}
