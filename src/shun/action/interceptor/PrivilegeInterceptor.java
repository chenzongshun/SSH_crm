package shun.action.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import shun.domain.User;

/**
 * @author ˳
 * @version 2018��2��28�� ����11:20:57 Ȩ������������½������
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 1 ���session����
		Map<String, Object> session = ActionContext.getContext().getSession();

		// 2 ��session��ȡ��user
		Object object = session.get("user");

		if (object == null) {
			// 3 ���Ϊ�գ�˵��û�е�½
			
			// ��½�鷳�������������Զ���¼��
//			User user = new User();
//			user.setUser_code("1");
//			user.setUser_password("1");
//			user.setUser_name("����������������Զ���½");
//			ActionContext.getContext().getSession().put("user", user);
//			if (ActionContext.getContext().getSession().get("user")!=null) {
//				return invocation.invoke();
//			}
			return "toLogin";
		} else {
			// 4 ����վͷ��е���һ��������
			return invocation.invoke();
		}
	}
}