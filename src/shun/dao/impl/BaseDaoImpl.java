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
 * @author 顺
 * @version 2018年2月26日 下午6:54:39 既然不确定T的类型，那么久留着，让实现它的类再声明一个泛型T，然后后面的继续延用前面的那个
 */
@SuppressWarnings("all")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class clazz;// 用于接收运行期泛型的类型

	public BaseDaoImpl() {
		// 获得当前类型带有泛型类型的父类，实际在其它的继承这个类的运行环境中获取到的就是自己....BaseDaoImpl
		// 其实返回的是一个Type类型，没什么用，直接用它的子接口ParameterizedType来接收
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获得运行期的泛型类型，也就是说能够获得这个类的T到底是Customer类型还是LinkMan类型
		// 由于一个类可以声明多个泛型，所以它的返回值为Type[]，一个数组
		Type[] type = ptClass.getActualTypeArguments();
		clazz = (Class) type[0];// 由于当前类的泛型就一个，所以返回一个就好了
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
		// 按照正常的操作流程，删除需要从持久化状态调用delete方法删除
		T byId = this.getById(id);// 所以要先取，再删
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