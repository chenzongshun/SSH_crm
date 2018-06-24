package shun.dao;

import java.util.List;

import shun.domain.BaseDict;

/**
   * @author 顺
   * @version 2018年2月26日  下午11:01:26  
   */
public interface BaseDictDao extends BaseDao<BaseDict> {

	// 根据数据字典类型字段获得数据字典对象
	List<BaseDict> getListByTypeCode(String dict_type_code);
	
}
