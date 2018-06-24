package shun.utils;

/**
* @author czs 
* @version 创建时间：2018年2月23日 下午9:19:05---分页工具类 
*/
import java.util.List;

@SuppressWarnings("all")
public class PageBean {

	private Integer currentPage;// 当前页数
	private Integer totalCount;// 总记录数
	private Integer pageSize;// 页面的总条数
	private Integer totalPage;// 总页数
	private List list;// 分页列表数据
	
	/**
	 * @param currentPage
	 *            当前页
	 * @param totalCount
	 *            从数据库查询的总页数
	 * @param pageSize 
	 *            每页显示记录数
	 */
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {

		this.totalCount = totalCount;// 是程序员自己从数据库查的

		// 由于下面两个参数不确定客户端会不会给，所以需要处理
		this.currentPage = currentPage;
		this.pageSize = pageSize;

		if (this.currentPage == null) {// 如果页面没有指定显示哪一页，那么就显示第一页
			this.currentPage = 1;
		}
		if (this.pageSize == null) {// 每页显示条数没有指定，那么每页指定显示三条
			this.pageSize = 40;
		}
		// 计算总页数 = 总记录数 + 页面显示总条数 - 1 后 / 以页面显示总条数
		// 假设有100条数据，每页10条显示，那么100+10-1=109，109/10=10页---101+10-1=110/10=11
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		// 判断当前页数是否超出范围
		// 当前页小于1
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		// 当前页大于总页数
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	// 计算起始索引
	public int getStart() {
		return (this.currentPage - 1) * this.pageSize;
	} 

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
