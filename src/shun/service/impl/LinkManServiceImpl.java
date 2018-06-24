package shun.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import shun.dao.LinkManDao;
import shun.domain.LinkMan;
import shun.service.LinkManService;
import shun.utils.PageBean;

/**
   * @author ˳
   * @version 2018��2��28��  ����11:30:55  
   */
public class LinkManServiceImpl implements LinkManService {

	private LinkManDao linkManDao;
	
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	@Override
	public void add(LinkMan linkMan) {
		linkManDao.saveOrUpdate(linkMan);
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1 ����Dao��ѯ�ܼ�¼��
		int totalCount = linkManDao.getTotalCount(dc);

		// 2 ����PageBean����
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

		// 3 ����Dao��ѯ��ҳ�б�����
		List<LinkMan> list = linkManDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
		pageBean.setList(list);
		
		// 4 ���б����ݷ���pageBean�У�������
		
		return pageBean;
	}

	@Override
	/**
	 * ����id��ѯ��ϵ��
	 */
	public LinkMan getById(Long getlKm_id) {
		return linkManDao.getById(getlKm_id);
	}

}
