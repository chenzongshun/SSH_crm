package shun.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shun.dao.UserDao;
import shun.domain.User;
import shun.service.UserService;

/**
 * @author czs
 * @version 创建时间：2018年2月22日 下午8:27:05
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

	@Override
	/**
	 * 登陆方法
	 */
	public User getUserByCodePassword(User u) {
		// 1 根据登陆名称查询登陆用户
		User exisuser = userDao.getByUserCode(u.getUser_code());

		// 2 判断用户是否存在，不存在就抛出异常，提示用户名不存在
		if (exisuser == null) {
			throw new RuntimeException("用户名不存在！");
		}

		// 3 判断用户密码是否正确，如果不正确就抛出异常，提示密码错误
		if (!exisuser.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误！");
		}

		// 4 返回查询到的user对象
		return exisuser;
	}

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	/**
	 * 注册用户
	 * 
	 * @param u
	 */
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User u) {
		// 查询要注册的用户
		User existUser = userDao.getByUserCode(u.getUser_code());
		
		// 如果存在的话就抛出异常
		if (existUser!=null) {
			throw new RuntimeException("用户名已被使用!");
		}
		
		// 如果不存在就调用dao插入数据库
		else {
			userDao.save(u);
		}
	} 
}
