package shun.service;

import org.hibernate.criterion.DetachedCriteria;

import shun.domain.LinkMan;
import shun.utils.PageBean;

/**
   * @author ˳
   * @version 2018��2��28��  ����11:29:47  
   */
public interface LinkManService {

	/**
	 * �����ϵ��
	 * @param linkMan
	 */
	void add(LinkMan linkMan);

	// ��ѯ��ҳ��Ϣ
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//����id��ѯ��ϵ��
	LinkMan getById(Long getlKm_id);

}
