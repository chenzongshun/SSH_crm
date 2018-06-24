package shun.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.orm.hibernate5.HibernateCallback;

import shun.dao.CustomerDao;
import shun.domain.Customer;

/**
 * @author czs
 * @version 创建时间：2018年2月23日 下午10:34:30
 */
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	/**
	 * 客户的行业以及人数
	 * 
	 * @return
	 */
	@Override
	public List<Object[]> totalIndustry() {
		String sql = "SELECT dict_item_name h,COUNT(*) r       			   	"
				+ "		FROM base_dict b INNER JOIN  cst_customer c   	"
				+ "		ON c.cust_industry = b.dict_id            	  					"
				+ "		GROUP BY dict_item_name                   				    ";
		List<Object[]> list = this.getHibernateTemplate().execute(new HibernateCallback<List<Object[]>>() {

			@Override
			public List<Object[]> doInHibernate(Session session) throws HibernateException {
				@SuppressWarnings("unchecked")
				NativeQuery<Object[]> query = session.createNativeQuery(sql);
				List<Object[]> list = query.getResultList();
				for (int i = 0; i < list.size(); i++) {
					Object[] cells = list.get(i);
					System.out.print("第 "+(i+1)+" 行\t");
					for (int y = 0; y < cells.length; y++) {  
						System.out.print(cells[y] + "\t\t");
					}
					System.out.println();
				}
				return list;
			}
		});
		return list;
	}
}
