package shun.dao;
/**
* @author czs
* @version 创建时间：2018年2月23日 上午9:30:24 
*/

import shun.domain.User;

public interface UserDao extends BaseDao<User>{
	// 根据登陆名称查询user对象
	User getByUserCode(String usercode);
 
}
