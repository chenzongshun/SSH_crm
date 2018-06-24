package shun.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import shun.domain.LinkMan;
import shun.service.LinkManService;
import shun.utils.PageBean;

/**
   * @author 顺
   * @version 2018年2月28日  上午10:55:30  
   */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private static final long serialVersionUID = 1L;
	LinkMan linkMan = new LinkMan();
	private LinkManService linkManService;

	private Integer currentPage;
	private Integer pageSize;

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	@Override
	public LinkMan getModel() {
		return linkMan;
	}

	// 添加一个联系人，其实就是和客户表的id进行关联
	public String add() throws Exception {
		linkManService.add(linkMan);
		return "toList";
	}

	public String list() throws Exception {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if (StringUtils.isNoneBlank(linkMan.getLkm_name())&&linkMan.getLkm_name().length()!=0) {// 判断并封装参数
			dc.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
		}
		if (linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null) {
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		// 1 调用Service查询分页数据（pageBean）
		PageBean pageBean = linkManService.getPageBean(dc, currentPage, pageSize);
		// 2 将pageBean放入request域，转发到列表页显示
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
	
	public String toEidt() throws Exception {
		// 去service根据id查询联系人
		LinkMan l = linkManService.getById(linkMan.getlKm_id());
		// 添加到request域
		ActionContext.getContext().put("linkman", l);
		String gender = l.getLkm_gender().toString();
		ActionContext.getContext().put("gender", gender);
		return "ToEdit";
	}
}
