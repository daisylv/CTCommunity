package weiboAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserInfo extends ActionSupport {

	public static final String FAILURE = "failure";
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();

	private static final long serialVersionUID = 1L;

	public String execute() {
		String userId = (String) request.getSession().getAttribute("userId");
		System.out.println(userId);
		if (userId == null)
			return FAILURE;
		return SUCCESS;
	}

}