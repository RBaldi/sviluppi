package org.stuff.ejb.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.stuff.ejb.hibernate.dao.UserDao;
import org.stuff.ejb.interceptor.CustomStuffAwInterceptor;
import org.stuff.ejb.model.User;


@Stateless
@Interceptors(CustomStuffAwInterceptor.class)
public class UserServiceImpl {
	
	@Autowired
	UserDao userDao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Integer insertUser(User user) {
		return userDao.insert(user);
		
	}
	
	
	public User findUserById(Integer id) {
		User retVal = null;
		
		retVal = userDao.findById(id);
		
		return retVal;
	}
	
	public String getUserName() {
		return "Test ottimo!";
	}
	
}
