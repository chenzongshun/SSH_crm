package shun.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import shun.dao.BaseDictDao;
import shun.domain.BaseDict;

/**
 * @author 顺
 * @version 2018年2月26日 下午11:02:35
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// 创建离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		// 添加查询条件
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		// 开始查询
		List<?> list = this.getHibernateTemplate().findByCriteria(dc);
		return (List<BaseDict>) list;
	}

}
