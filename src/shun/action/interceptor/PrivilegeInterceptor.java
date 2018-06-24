package shun.action.interceptor;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import shun.domain.User;

/**
 * @author 顺
 * @version 2018年2月28日 下午11:20:57 权限拦截器，登陆拦截器
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 1 获得session对象
		Map<String, Object> session = ActionContext.getContext().getSession();

		// 2 从session中取出user
		Object object = session.get("user");

		if (object == null) {
			// 3 如果为空，说明没有登陆
			
			// 登陆麻烦，，，，来个自动登录吧
//			User user = new User();
//			user.setUser_code("1");
//			user.setUser_password("1");
//			user.setUser_name("这是拦截器里面的自动登陆");
//			ActionContext.getContext().getSession().put("user", user);
//			if (ActionContext.getContext().getSession().get("user")!=null) {
//				return invocation.invoke();
//			}
			return "toLogin";
		} else {
			// 4 不会空就放行到下一个拦截器
			return invocation.invoke();
		}
	}
}