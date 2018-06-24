package shun.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import shun.domain.Customer;
import shun.utils.PageBean;

/**
* @author czs
* @version 创建时间：2018年2月23日 下午10:09:11 
*/
public interface CustomerService {

	/**
	 * 分页业务方法
	 * @param dc  
	 * @param currentPage 
	 * @param pageSize
	 * @return
	 */
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	/**
	 * 添加一个客户
	 * @param customer
	 */
	void add(Customer customer);

	/**
	 * 根据cust_id插叙客户对象
	 * @param cust_id
	 * @return
	 */
	Customer getById(Long cust_id);

	/**
	 * 获得每个行业以及人数
	 * @return
	 */
	List<Object[]> totalIndustry();

}
