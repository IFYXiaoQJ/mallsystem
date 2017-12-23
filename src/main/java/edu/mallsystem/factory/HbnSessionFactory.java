package edu.mallsystem.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 获取Hibernate Session 的工厂类
 * @author Administrator
 *
 */
@Repository
public class HbnSessionFactory {

	//声明SessionFactory
	@Resource
	private SessionFactory sessionFactory;

	//获取Session
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void setSf(SessionFactory sf) {
		this.sessionFactory = sf;
	}

}
