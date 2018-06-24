package shun.service;

import org.hibernate.criterion.DetachedCriteria;

import shun.domain.LinkMan;
import shun.utils.PageBean;

/**
   * @author 顺
   * @version 2018年2月28日  上午11:29:47  
   */
public interface LinkManService {

	/**
	 * 添加联系人
	 * @param linkMan
	 */
	void add(LinkMan linkMan);

	// 查询分页信息
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//根据id查询联系人
	LinkMan getById(Long getlKm_id);

}
