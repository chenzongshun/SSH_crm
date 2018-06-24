package shun.service.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import shun.dao.LinkManDao;
import shun.domain.LinkMan;
import shun.service.LinkManService;
import shun.utils.PageBean;

/**
   * @author 顺
   * @version 2018年2月28日  上午11:30:55  
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
		// 1 调用Dao查询总记录数
		int totalCount = linkManDao.getTotalCount(dc);

		// 2 创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

		// 3 调用Dao查询分页列表数据
		List<LinkMan> list = linkManDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
		pageBean.setList(list);
		
		// 4 将列表数据放入pageBean中，并返回
		
		return pageBean;
	}

	@Override
	/**
	 * 根据id查询联系人
	 */
	public LinkMan getById(Long getlKm_id) {
		return linkManDao.getById(getlKm_id);
	}

}
