package shun.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import shun.dao.SaleVisitDao;
import shun.domain.SaleVisit;
import shun.service.SaleVisitService;
import shun.utils.PageBean;

/**
   * @author ˳
   * @version 2018��3��1��  ����11:35:47  
   */
public class SaleVisitServiceImpl implements SaleVisitService {
	
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}

	SaleVisitDao saleVisitDao;

	@Override
	/**
	 * ��ӿͻ��ݷü�¼
	 */
	public void add(SaleVisit saleVist) {
		// û��ʲô�߼���ֱ�ӵ���dao��������
		saleVisitDao.saveOrUpdate(saleVist);
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1 ����Dao��ѯ�ܼ�¼��
				int totalCount = saleVisitDao.getTotalCount(dc);

				// 2 ����PageBean����
				PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

				// 3 ����Dao��ѯ��ҳ�б�����
				List<SaleVisit> list = saleVisitDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
				pageBean.setList(list);
				
				// 4 ���б����ݷ���pageBean�У�������
				
				return pageBean;
	}
} 