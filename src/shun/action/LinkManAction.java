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
   * @author ˳
   * @version 2018��2��28��  ����10:55:30  
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

	// ���һ����ϵ�ˣ���ʵ���ǺͿͻ����id���й���
	public String add() throws Exception {
		linkManService.add(linkMan);
		return "toList";
	}

	public String list() throws Exception {
		// ��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		if (StringUtils.isNoneBlank(linkMan.getLkm_name())&&linkMan.getLkm_name().length()!=0) {// �жϲ���װ����
			dc.add(Restrictions.like("lkm_name", "%" + linkMan.getLkm_name() + "%"));
		}
		if (linkMan.getCustomer()!=null&&linkMan.getCustomer().getCust_id()!=null) {
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}
		// 1 ����Service��ѯ��ҳ���ݣ�pageBean��
		PageBean pageBean = linkManService.getPageBean(dc, currentPage, pageSize);
		// 2 ��pageBean����request��ת�����б�ҳ��ʾ
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
	
	public String toEidt() throws Exception {
		// ȥservice����id��ѯ��ϵ��
		LinkMan l = linkManService.getById(linkMan.getlKm_id());
		// ��ӵ�request��
		ActionContext.getContext().put("linkman", l);
		String gender = l.getLkm_gender().toString();
		ActionContext.getContext().put("gender", gender);
		return "ToEdit";
	}
}
