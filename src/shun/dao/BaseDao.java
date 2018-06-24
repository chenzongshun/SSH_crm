package shun.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
   * @author ˳
   * @version 2018��2��26��  ����6:19:30  
   */
public interface BaseDao<T>{
	// ����͸����޸ķ���
	void saveOrUpdate(T t);
	
	// ��
	void save(T t);
	
	// ɾ
	void delete(T t);
	
	// ɾ
	void delete(Serializable id);//Serializable�����������ܹ���Ϊid�����ͣ���Щ���͵��ص㶼������ʵ���࣬�˴�����������͵İ�װ�඼ʵ����Serializable��StringҲ��
	
	// ��
	void update(T t);
	
	// ��--����id
	T getById(Serializable id);
	
	// ��--��ѯ�����������ܼ�¼��
	Integer getTotalCount(DetachedCriteria dc);
	
	// ��--��ѯ��ҳ�б�
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
}
