package shun.service;

import java.util.List;

import shun.domain.BaseDict;

/**
   * @author ˳
   * @version 2018��2��26��  ����10:57:34  
   */
public interface BaseDictService {

	// ���������ֵ������ֶλ�������ֵ����
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
