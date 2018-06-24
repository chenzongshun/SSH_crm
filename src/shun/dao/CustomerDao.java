package shun.dao;

import java.util.List;

import shun.domain.Customer;

/**
* @author czs
* @version 创建时间：2018年2月23日 下午10:32:01 
*/
public interface CustomerDao extends BaseDao<Customer>{

	/**
	 * 客户的行业以及人数
	 * @return
	 */
	List<Object[]> totalIndustry();

}
