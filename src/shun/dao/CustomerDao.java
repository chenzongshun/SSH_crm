package shun.dao;

import java.util.List;

import shun.domain.Customer;

/**
* @author czs
* @version ����ʱ�䣺2018��2��23�� ����10:32:01 
*/
public interface CustomerDao extends BaseDao<Customer>{

	/**
	 * �ͻ�����ҵ�Լ�����
	 * @return
	 */
	List<Object[]> totalIndustry();

}
