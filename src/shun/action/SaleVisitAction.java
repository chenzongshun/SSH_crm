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
   * @author ˳
   * @version 2018��3��1��  ����11:32:23  
   */
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{

	private static final long serialVersionUID = 1L;
	private SaleVisitService saleVistService;

	public SaleVisitService getSaleVistService() {
		return saleVistService;
	}

	/**
	 * ��ӿͻ��ݷü�¼
	 */
	public String add() throws Exception {
		/*ȡ����½�û�������SaleVisitʵ��*/
		User u = (User) ActionContext.getContext().getSession().get("user");
		saleVist.setUser(u);
		
		saleVist.setVisit_id(UUID.randomUUID().toString());
		
		// ֱ�Ӵ���Service���
		saleVistService.add(saleVist);
		// �ض�����ʾ�ͻ��ݷü�¼��Action
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
		// ��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(SaleVisit.class);
		try {
			if (saleVist != null && saleVist.getCustomer() != null && saleVist.getCustomer().getCust_id()!=null) {// �жϲ���װ����
				// dc.add(Restrictions.eq("sale_cust_id", saleVist.getCustomer().getCust_id()));// �������ݿ��е�ȷ������ֶΣ���.......������hibernate��������������ݿ�ģ�
				dc.add(Restrictions.eq("customer.cust_id", saleVist.getCustomer().getCust_id()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// 1 ����Service��ѯ��ҳ���ݣ�pageBean��
		PageBean pageBean = saleVistService.getPageBean(dc, currentPage, pageSize);
		// 2 ��pageBean����request��ת�����б�ҳ��ʾ
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
