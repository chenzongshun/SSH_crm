package shun.service;

import shun.domain.User;

/**
* @author czs
* @version 创建时间：2018年2月22日 下午8:22:17 
*/
public interface UserService {
	
	/**
	 * 登陆用户
	 * @param u
	 * @return
	 */
	User getUserByCodePassword(User u);

	/**
	 * 注册用户
	 * @param u
	 */
	void saveUser(User u);
 
}
