package com.lm.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lm.bos.dao.base.IBaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

	//sessionFactory需要spring依赖注入
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	
	//通过构造方法获取T实际代表的类
	private Class<T> entityClass;
	public BaseDaoImpl() {
		//获取父类BaseDaoImpl<T>
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//得到T数组
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		
	}

	@Override
	public T findById(Serializable id) {
		
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		String hql = "FROM " + entityClass.getSimpleName();
		return this.getHibernateTemplate().find(hql);
	}

}
