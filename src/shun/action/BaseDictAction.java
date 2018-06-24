package shun.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;

import shun.domain.BaseDict;
import shun.service.BaseDictService;

/**
   * @author 顺
   * @version 2018年2月26日  下午10:30:34  
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
	 * 给异步查询准备数据
	 */
	public String execute() throws Exception {
		// 1 调用Service根据typecode获得数据字典对象list
		List<BaseDict> list =  baseDictService.getListByTypeCode(dict_type_code);
		
		// 2 将list转换为josn
		String json = JSONArray.toJSONString(list);
		
		// 3 将json发送给浏览器------一定要声明"application/json;charset=utf-8"
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);

		return null;//这是ajax请求，不要走到新的页面
	}
}
