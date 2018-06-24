package shun.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import shun.dao.SaleVisitDao;
import shun.domain.SaleVisit;
import shun.service.SaleVisitService;
import shun.utils.PageBean;

/**
   * @author 顺
   * @version 2018年3月1日  上午11:35:47  
   */
public class SaleVisitServiceImpl implements SaleVisitService {
	
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}

	SaleVisitDao saleVisitDao;

	@Override
	/**
	 * 添加客户拜访记录
	 */
	public void add(SaleVisit saleVist) {
		// 没有什么逻辑，直接调用dao存入数据
		saleVisitDao.saveOrUpdate(saleVist);
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1 调用Dao查询总记录数
				int totalCount = saleVisitDao.getTotalCount(dc);

				// 2 创建PageBean对象
				PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

				// 3 调用Dao查询分页列表数据
				List<SaleVisit> list = saleVisitDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
				pageBean.setList(list);
				
				// 4 将列表数据放入pageBean中，并返回
				
				return pageBean;
	}
} 