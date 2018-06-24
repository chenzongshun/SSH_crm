package shun.action;

import java.util.UUID;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import shun.domain.SaleVisit;
import shun.domain.User;
import shun.service.SaleVisitService;
import shun.utils.PageBean;

/**
   * @author 顺
   * @version 2018年3月1日  上午11:32:23  
   */
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{

	private static final long serialVersionUID = 1L;
	private SaleVisitService saleVistService;

	public SaleVisitService getSaleVistService() {
		return saleVistService;
	}

	/**
	 * 添加客户拜访记录
	 */
	public String add() throws Exception {
		/*取出登陆用户，放入SaleVisit实体*/
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVist.setUser(u);
		
		saleVist.setVisit_id(UUID.randomUUID().toString());
		
		// 直接传到Service添加
		saleVistService.add(saleVist);
		// 重定向到显示客户拜访记录的Action
		return "toList";
	}

	private Integer currentPage;
	private Integer pageSize;

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String list() throws Exception {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		try {
			if (saleVist != null && saleVist.getCustomer() != null && saleVist.getCustomer().getCust_id()!=null) {// 判断并封装参数
				// dc.add(Restrictions.eq("sale_cust_id", saleVist.getCustomer().getCust_id()));// 错误数据库中的确有这个字段，但.......别忘了hibernate是以面向对象数据库的！
				dc.add(Restrictions.eq("customer.cust_id", saleVist.getCustomer().getCust_id()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// 1 调用Service查询分页数据（pageBean）
		PageBean pageBean = saleVistService.getPageBean(dc, currentPage, pageSize);
		// 2 将pageBean放入request域，转发到列表页显示
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}

	public void setSaleVistService(SaleVisitService saleVistService) {
		this.saleVistService = saleVistService;
	}

	SaleVisit saleVist = new SaleVisit();
	
	@Override
	public SaleVisit getModel() {
		return saleVist;
	}
}
