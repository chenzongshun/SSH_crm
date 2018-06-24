package shun.test;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import shun.dao.UserDao;
import shun.domain.User;
import shun.service.UserService;

/**
* @author czs
* @version 创建时间：2018年2月22日 下午10:12:08 测试hibernate框架 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name = "userDao")
	private UserDao ud;
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Resource(name="userService")
	private UserService userService;
	
	@Test
	/**
	 * 单独配置hibernate时用来测试的----------记得用这个记得去掉类上面的两个注解，否则出错
	 */
	public void fun() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------------
		User user  = new User();
		user.setUser_code("tom");
		user.setUser_name("汤姆");
		user.setUser_password("1234");
		session.save(user);
		//---------------------------------------------------------
		tx.commit();
		session.close();
		sf.close();
	}

	

	@Test
	/**
	 * 整合hibernate与spring时管理sessionFactory的测试
	 */
	public void fun2() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		//---------------------------------------------------------
		User user  = new User();
		user.setUser_code("tom1");
		user.setUser_name("汤姆"+new Date());
		user.setUser_password("1234");
		session.save(user);
		//---------------------------------------------------------
		tx.commit();
		session.close();
	}

	@Test
	/**
	 * 测试Dao，整合hibernate模板
	 */
	public void fun3() {
		User user = ud.getByUserCode("to111m");
		System.out.println(user);
	}
	
	@Test
	/**
	 * 测试xml以及注解aop事务
	 */
	public void fun4() {
		User user  = new User();
		user.setUser_code("tom");
		user.setUser_name("123456");
		user.setUser_password("1234");
		userService.saveUser(user);
	}
	
	
	
}
