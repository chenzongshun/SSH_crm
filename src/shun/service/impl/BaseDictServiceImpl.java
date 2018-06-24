package shun.service.impl;

import java.util.List;

import shun.dao.BaseDictDao;
import shun.domain.BaseDict;
import shun.service.BaseDictService;

/**
   * @author 顺
   * @version 2018年2月26日  下午10:59:07  
   */
public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		// 没有业务逻辑，直接调用dao方法
		List<BaseDict> list = baseDictDao.getListByTypeCode(dict_type_code);
		return list;
	}

}
