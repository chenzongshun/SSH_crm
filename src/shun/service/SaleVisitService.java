package shun.service;

import org.hibernate.criterion.DetachedCriteria;

import shun.domain.SaleVisit;
import shun.utils.PageBean;

/**
   * @author ˳
   * @version 2018��3��1��  ����11:34:52  
   */
public interface SaleVisitService {

	/**
	 * ��ӿͻ��ݷü�¼
	 * @param saleVist
	 */
	void add(SaleVisit saleVist);

	/**
	 * ��ҳҵ�񷽷�
	 * @param dc
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
}
