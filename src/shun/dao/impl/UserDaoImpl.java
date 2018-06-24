package shun.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import shun.dao.UserDao;
import shun.domain.User;

/**
 * @author czs
 * @version 创建时间：2018年2月23日 上午9:31:28
 */
// 别忘了为HibernateDaoSupport注入sessionFactory
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	// 根据登陆名称查询user对象
	public User getByUserCode(final String usercode) {
		// HQL
//		User user = getHibernateTemplate().execute(new HibernateCallback<User>() {
//			@Override
//			public User doInHibernate(Session session) throws HibernateException {
//				String hql = "from User where user_code = ?";
//				Query<?> query = session.createQuery(hql);
//				query.setParameter(0, usercode);
//				// User user = (User) query.uniqueResult();//由于数据库中存在多条记录，所以抛出异常
//				return (User) query.uniqueResult();
//			}
//		});
//		if (user != null) {// 这里如果空的话就采用下面的criteria查询，实践两种方法
//			return user;
//		}

		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", usercode));
		List<?> userlist = getHibernateTemplate().findByCriteria(dc);

		if (userlist != null && userlist.size() > 0) {
			return (User) userlist.get(0);
		} else {
			return null;
		}
	} 
}
