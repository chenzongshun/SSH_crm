package shun.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;

import shun.domain.BaseDict;
import shun.service.BaseDictService;

/**
   * @author ˳
   * @version 2018��2��26��  ����10:30:34  
   */
public class BaseDictAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private String dict_type_code;
	private BaseDictService baseDictService;
	
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	@Override
	/**
	 * ���첽��ѯ׼������
	 */
	public String execute() throws Exception {
		// 1 ����Service����typecode��������ֵ����list
		List<BaseDict> list =  baseDictService.getListByTypeCode(dict_type_code);
		
		// 2 ��listת��Ϊjosn
		String json = JSONArray.toJSONString(list);
		
		// 3 ��json���͸������------һ��Ҫ����"application/json;charset=utf-8"
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;//����ajax���󣬲�Ҫ�ߵ��µ�ҳ��
	}
}
