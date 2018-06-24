package shun.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import shun.domain.User;
import shun.service.UserService;

/**
* @author czs
* @version ����ʱ�䣺2018��2��22�� ����1:00:09 
*/
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private static final long serialVersionUID = 1203350742782158812L;
	
	// ע���û�
	public String regist() throws Exception {
		// ����service�����û�
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			// ��Ϊstruts������������һ��ȫ�ֵ�����error����������Ϊjava.lang.Exception���Ѿ���ռ����
			// �������Զ����쳣����Ҫ�ֶ��̳�RuntimeException�������ᴴ���ܶ����
			// ����Ϊ֪���˷���������ܻ��׳��쳣�������������try�ˣ��洢������Ϣ��request����action��toRegist
			ActionContext.getContext().put("error", e.getMessage());
			return "toRegist";
		}
		// �ض��򵽵�¼����
		return "toLogin";
	}

	// ��½
	public String login() throws Exception {
		// 1 ����Serviceִ�е�½�߼�
		User u = userService.getUserByCodePassword(user);
		
		// 2 �����ص�User�������session��
		ActionContext.getContext().getSession().put("user", u);
		
		// 3 �ض������Ŀ��ҳ
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
