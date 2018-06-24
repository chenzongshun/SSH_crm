package shun.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import shun.dao.CustomerDao;
import shun.domain.Customer;
import shun.service.CustomerService;
import shun.utils.PageBean;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��23�� ����10:10:38
 */
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	/**
	 * ��ҳҵ�񷽷�
	 */
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// 1 ����Dao��ѯ�ܼ�¼��
		int totalCount = customerDao.getTotalCount(dc);

		// 2 ����PageBean����
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);

		// 3 ����Dao��ѯ��ҳ�б�����
		List<Customer> list = customerDao.getPageList(dc, pageBean.getStart(), pageBean.getPageSize());
		pageBean.setList(list);
		
		// 4 ���б����ݷ���pageBean�У�������
		
		return pageBean;
	}

	@Override
	public void add(Customer customer) {
		customerDao.saveOrUpdate(customer);
	}

	@Override
	/**
	 * ����cust_id����ͻ�����
	 */
	public Customer getById(Long cust_id) {
		return customerDao.getById(cust_id);
	}

	@Override
	/**
	 * ���ÿ����ҵ�Լ�����
	 */
	public List<Object[]> totalIndustry() {
		return customerDao.totalIndustry();
	}

}