package shun.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
   * @author 顺
   * @version 2018年2月26日  下午6:19:30  
   */
public interface BaseDao<T>{
	// 保存和更新修改方法
	void saveOrUpdate(T t);
	
	// 增
	void save(T t);
	
	// 删
	void delete(T t);
	
	// 删
	void delete(Serializable id);//Serializable覆盖了所有能够作为id的类型，这些类型的特点都是它的实现类，八大基本数据类型的包装类都实现了Serializable，String也是
	
	// 改
	void update(T t);
	
	// 查--根据id
	T getById(Serializable id);
	
	// 查--查询符合条件的总记录数
	Integer getTotalCount(DetachedCriteria dc);
	
	// 查--查询分页列表
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);
	
}
