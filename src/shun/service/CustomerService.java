package shun.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import shun.domain.Customer;
import shun.utils.PageBean;

/**
* @author czs
* @version ����ʱ�䣺2018��2��23�� ����10:09:11 
*/
public interface CustomerService {

	/**
	 * ��ҳҵ�񷽷�
	 * @param dc  
	 * @param currentPage 
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	/**
	 * ���һ���ͻ�
	 * @param customer
	 */
	void add(Customer customer);

	/**
	 * ����cust_id����ͻ�����
	 * @param cust_id
	 * @return
	 */
	Customer getById(Long cust_id);

	/**
	 * ���ÿ����ҵ�Լ�����
	 * @return
	 */
	List<Object[]> totalIndustry();

}
