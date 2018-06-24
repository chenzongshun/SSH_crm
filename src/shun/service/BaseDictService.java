package shun.service;

import java.util.List;

import shun.domain.BaseDict;

/**
   * @author 顺
   * @version 2018年2月26日  下午10:57:34  
   */
public interface BaseDictService {

	// 根据数据字典类型字段获得数据字典对象
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
