package shun.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import shun.dao.BaseDictDao;
import shun.domain.BaseDict;

/**
 * @author ˳
 * @version 2018��2��26�� ����11:02:35
 */
public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// �������߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(BaseDict.class);
		// ��Ӳ�ѯ����
		dc.add(Restrictions.eq("dict_type_code", dict_type_code));
		// ��ʼ��ѯ
		List<?> list = this.getHibernateTemplate().findByCriteria(dc);
		return (List<BaseDict>) list;
	}

}
