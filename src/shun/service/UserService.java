package shun.service;

import shun.domain.User;

/**
* @author czs
* @version ����ʱ�䣺2018��2��22�� ����8:22:17 
*/
public interface UserService {
	
	/**
	 * ��½�û�
	 * @param u
	 * @return
	 */
	User getUserByCodePassword(User u);

	/**
	 * ע���û�
	 * @param u
	 */
	void saveUser(User u);
 
}