package shun.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import shun.dao.UserDao;
import shun.domain.User;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��23�� ����9:31:28
 */
// ������ΪHibernateDaoSupportע��sessionFactory
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	// ���ݵ�½���Ʋ�ѯuser����
	public User getByUserCode(final String usercode) {
		// HQL
//		User user = getHibernateTemplate().execute(new HibernateCallback<User>() {
//			@Override
//			public User doInHibernate(Session session) throws HibernateException {
//				String hql = "from User where user_code = ?";
//				Query<?> query = session.createQuery(hql);
//				query.setParameter(0, usercode);
//				// User user = (User) query.uniqueResult();//�������ݿ��д��ڶ�����¼�������׳��쳣
//				return (User) query.uniqueResult();
//			}
//		});
//		if (user != null) {// ��������յĻ��Ͳ��������criteria��ѯ��ʵ�����ַ���
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