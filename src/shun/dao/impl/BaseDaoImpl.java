package shun.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import shun.dao.BaseDao;

/**
 * @author ˳
 * @version 2018��2��26�� ����6:54:39 ��Ȼ��ȷ��T�����ͣ���ô�����ţ���ʵ��������������һ������T��Ȼ�����ļ�������ǰ����Ǹ�
 */
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;// ���ڽ��������ڷ��͵�����

	public BaseDaoImpl() {
		// ��õ�ǰ���ʹ��з������͵ĸ��࣬ʵ���������ļ̳����������л����л�ȡ���ľ����Լ�....BaseDaoImpl
		// ��ʵ���ص���һ��Type���ͣ�ûʲô�ã�ֱ���������ӽӿ�ParameterizedType������
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// ��������ڵķ������ͣ�Ҳ����˵�ܹ����������T������Customer���ͻ���LinkMan����
		// ����һ�����������������ͣ��������ķ���ֵΪType[]��һ������
		Type[] type = ptClass.getActualTypeArguments();
		clazz = (Class) type[0];// ���ڵ�ǰ��ķ��;�һ�������Է���һ���ͺ���
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		// ���������Ĳ������̣�ɾ����Ҫ�ӳ־û�״̬����delete����ɾ��
		T byId = this.getById(id);// ����Ҫ��ȡ����ɾ
		getHibernateTemplate().delete(byId);
	}

	@Override
	public void update(T t) { 
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		return (T) getHibernateTemplate().get(clazz, id);
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = null;
		try {
			list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		dc.setProjection(null);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}
 
	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer pageSize) {
		List<?> list = this.getHibernateTemplate().findByCriteria(dc, start, pageSize);
		return (List<T>) list;
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}
} 