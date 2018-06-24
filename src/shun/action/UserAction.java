package shun.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import shun.domain.User;
import shun.service.UserService;

/**
* @author czs
* @version 创建时间：2018年2月22日 下午1:00:09 
*/
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private static final long serialVersionUID = 1203350742782158812L;
	
	// 注册用户
	public String regist() throws Exception {
		// 调用service保存用户
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			// 因为struts配置里面有了一个全局的配置error，并且类型为java.lang.Exception，已经被占用了
			// 又由于自定义异常还需要手动继承RuntimeException，这样会创建很多个类
			// 又因为知道此方法里面可能会抛出异常，所以在这里就try了，存储错误信息到request域并让action走toRegist
			ActionContext.getContext().put("error", e.getMessage());
			return "toRegist";
		}
		// 重定向到登录界面
		return "toLogin";
	}

	// 登陆
	public String login() throws Exception {
		// 1 调用Service执行登陆逻辑
		User u = userService.getUserByCodePassword(user);
		
		// 2 将返回的User对象放入session域
		ActionContext.getContext().getSession().put("user", u);
		
		// 3 重定向道项目首页
		return "toHome";
	}
	

	
	public void setUser(User user) {
		this.user = user;
	}
	
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}
}
