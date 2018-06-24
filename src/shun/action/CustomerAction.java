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
 * @version 创建时间：2018年2月23日 下午9:46:14
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	// 上传的文件会自动封装到File对象
	// 在后台提供一个与前台input type=file组件的name属性相同的值
	private File file;
	// 在提交名后加上固定的后缀FileName，文件名称会自动封装到属性中
	private String fileFileName;
	// 在提交文件名后加上固定的后缀ContentType，文件MIME类型会自动封装到属性中
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
			file.renameTo(new File("C:/Users/Administrator/Desktop/no-session的解决0223/" + fileFileName));
			System.err.println("文件类型：" + fileContentType);
		}
		// 调用service保存客户
		customerService.add(customer);
		// 跳到客户列表显示页
		return "toList";
	}

	public String edit() throws Exception {
		// 1 去service方法插叙客户对象---根据cust_id插叙客户对象
		Customer c = customerService.getById(customer.getCust_id());
		// 2 将客户对象存储到request域中
		ActionContext.getContext().put("customer", c);
		// 3 转发到编辑页面
		return "edit";
	}

	public String list() throws Exception {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNoneBlank(customer.getCust_name())) {// 判断并封装参数
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		// 1 调用Service查询分页数据（pageBean）
		PageBean pageBean = customerService.getPageBean(dc, currentPage, pageSize);
		// 2 将pageBean放入request域，转发到列表页显示
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}
}