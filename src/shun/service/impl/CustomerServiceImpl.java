package shun.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import shun.dao.CustomerDao;
import shun.domain.Customer;
import shun.service.CustomerService;
import shun.utils.PageBean;

/**
 * @author czs
 * @version 创建时间：2018年2月23日 下午10:10:38
 */
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	/**
	 * 分页业务方法
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1 调用Dao查询总记录数
		int totalCount = customerDao.getTotalCount(dc);

		// 2 创建PageBean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

		// 3 调用Dao查询分页列表数据
		List<Customer> list = customerDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
		pageBean.setList(list);
		
		// 4 将列表数据放入pageBean中，并返回
		
		return pageBean;
	}

	@Override
	public void add(Customer customer) {
		customerDao.saveOrUpdate(customer);
	}

	@Override
	/**
	 * 根据cust_id插叙客户对象
	 */
	public Customer getById(Long cust_id) {
		return customerDao.getById(cust_id);
	}

	@Override
	/**
	 * 获得每个行业以及人数
	 */
	public List<Object[]> totalIndustry() {
		return customerDao.totalIndustry();
	}

}
