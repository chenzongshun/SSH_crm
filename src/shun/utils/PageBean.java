package shun.utils;

/**
* @author czs 
* @version ����ʱ�䣺2018��2��23�� ����9:19:05---��ҳ������ 
*/
import java.util.List;

@SuppressWarnings("all")
public class PageBean {

	private Integer currentPage;// ��ǰҳ��
	private Integer totalCount;// �ܼ�¼��
	private Integer pageSize;// ҳ���������
	private Integer totalPage;// ��ҳ��
	private List list;// ��ҳ�б�����
	
	/**
	 * @param currentPage
	 *            ��ǰҳ
	 * @param totalCount
	 *            �����ݿ��ѯ����ҳ��
	 * @param pageSize 
	 *            ÿҳ��ʾ��¼��
	 */
	public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {

		this.totalCount = totalCount;// �ǳ���Ա�Լ������ݿ���

		// ������������������ȷ���ͻ��˻᲻�����������Ҫ����
		this.currentPage = currentPage;
		this.pageSize = pageSize;

		if (this.currentPage == null) {// ���ҳ��û��ָ����ʾ��һҳ����ô����ʾ��һҳ
			this.currentPage = 1;
		}
		if (this.pageSize == null) {// ÿҳ��ʾ����û��ָ������ôÿҳָ����ʾ����
			this.pageSize = 40;
		}
		// ������ҳ�� = �ܼ�¼�� + ҳ����ʾ������ - 1 �� / ��ҳ����ʾ������
		// ������100�����ݣ�ÿҳ10����ʾ����ô100+10-1=109��109/10=10ҳ---101+10-1=110/10=11
		this.totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		// �жϵ�ǰҳ���Ƿ񳬳���Χ
		// ��ǰҳС��1
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		// ��ǰҳ������ҳ��
		if (this.currentPage > this.totalPage) {
			this.currentPage = this.totalPage;
		}
	}
	// ������ʼ����
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
