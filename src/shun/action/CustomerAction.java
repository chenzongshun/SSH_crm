package shun.action;

import java.io.File;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import shun.domain.Customer;
import shun.service.CustomerService;
import shun.utils.PageBean;

/**
 * @author czs
 * @version ����ʱ�䣺2018��2��23�� ����9:46:14
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	// �ϴ����ļ����Զ���װ��File����
	// �ں�̨�ṩһ����ǰ̨input type=file�����name������ͬ��ֵ
	private File file;
	// ���ύ������Ϲ̶��ĺ�׺FileName���ļ����ƻ��Զ���װ��������
	private String fileFileName;
	// ���ύ�ļ�������Ϲ̶��ĺ�׺ContentType���ļ�MIME���ͻ��Զ���װ��������
	private String fileContentType;

	private Customer customer = new Customer();

	private CustomerService customerService;

	public void setFile(File file) {
		this.file = file;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	private static final long serialVersionUID = 1L;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	private Integer currentPage;
	private Integer pageSize;

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String IndustryCount() throws Exception {
		List<Object[]> list = customerService.totalIndustry();
		ActionContext.getContext().put("list", list);
		return "IndustryCount";
	}

	public String add() throws Exception {
		if (file!=null) {
			file.renameTo(new File("C:/Users/Administrator/Desktop/no-session�Ľ��0223/" + fileFileName));
			System.err.println("�ļ����ͣ�" + fileContentType);
		}
		// ����service����ͻ�
		customerService.add(customer);
		// �����ͻ��б���ʾҳ
		return "toList";
	}

	public String edit() throws Exception {
		// 1 ȥservice��������ͻ�����---����cust_id����ͻ�����
		Customer c = customerService.getById(customer.getCust_id());
		// 2 ���ͻ�����洢��request����
		ActionContext.getContext().put("customer", c);
		// 3 ת�����༭ҳ��
		return "edit";
	}

	public String list() throws Exception {
		// ��װ���߲�ѯ����
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNoneBlank(customer.getCust_name())) {// �жϲ���װ����
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		// 1 ����Service��ѯ��ҳ���ݣ�pageBean��
		PageBean pageBean = customerService.getPageBean(dc, currentPage, pageSize);
		// 2 ��pageBean����request��ת�����б�ҳ��ʾ
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
}