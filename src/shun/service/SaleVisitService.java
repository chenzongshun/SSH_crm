package shun.service;

import org.hibernate.criterion.DetachedCriteria;

import shun.domain.SaleVisit;
import shun.utils.PageBean;

/**
   * @author 顺
   * @version 2018年3月1日  上午11:34:52  
   */
public interface SaleVisitService {

	/**
	 * 添加客户拜访记录
	 * @param saleVist
	 */
	void add(SaleVisit saleVist);

	/**
	 * 分页业务方法
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
}
