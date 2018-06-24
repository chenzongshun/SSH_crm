package shun.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import shun.dao.UserDao;
import shun.domain.User;
import shun.service.UserService;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��22�� ����8:27:05
 */
@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

	@Override
	/**
	 * ��½����
	 */
	public User getUserByCodePassword(User u) {
		// 1 ���ݵ�½���Ʋ�ѯ��½�û�
		User exisuser = userDao.getByUserCode(u.getUser_code());

		// 2 �ж��û��Ƿ���ڣ������ھ��׳��쳣����ʾ�û���������
		if (exisuser == null) {
			throw new RuntimeException("�û��������ڣ�");
		}

		// 3 �ж��û������Ƿ���ȷ���������ȷ���׳��쳣����ʾ�������
		if (!exisuser.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("�������");
		}

		// 4 ���ز�ѯ����user����
		return exisuser;
	}

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	/**
	 * ע���û�
	 * 
	 * @param u
	 */
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User u) {
		// ��ѯҪע����û�
		User existUser = userDao.getByUserCode(u.getUser_code());
		
		// ������ڵĻ����׳��쳣
		if (existUser!=null) {
			throw new RuntimeException("�û����ѱ�ʹ��!");
		}
		
		// ��������ھ͵���dao�������ݿ�
		else {
			userDao.save(u);
		}
	} 
}