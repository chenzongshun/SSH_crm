package shun.dao;

import java.util.List;

import shun.domain.BaseDict;

/**
   * @author ˳
   * @version 2018��2��26��  ����11:01:26  
   */
public interface BaseDictDao extends BaseDao<BaseDict> {

	// ���������ֵ������ֶλ�������ֵ����
	List<BaseDict> getListByTypeCode(String dict_type_code);
	
}
