package shun.service.impl;

import java.util.List;

import shun.dao.BaseDictDao;
import shun.domain.BaseDict;
import shun.service.BaseDictService;

/**
   * @author ˳
   * @version 2018��2��26��  ����10:59:07  
   */
public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// û��ҵ���߼���ֱ�ӵ���dao����
		List<BaseDict> list = baseDictDao.getListByTypeCode(dict_type_code);
		return list;
	}

}
