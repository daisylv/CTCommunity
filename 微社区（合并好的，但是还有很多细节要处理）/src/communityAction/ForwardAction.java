package communityAction;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import communityDB.AccountHelper;

public class ForwardAction extends ActionSupport {
	/**
	 * @author bjrara
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	public static final String FAILURE = "failure";
	
	public String execute(){
		
		return SUCCESS;
	}
	
	public String forwardToWeibo(){
		request = ServletActionContext.getRequest();
		int replyId = Integer.parseInt(request.getParameter("replyId"));
		AccountHelper helper = AccountHelper.INSTANCE;
		if (helper.forwardToWeibo(replyId))
			return null;
		return FAILURE;
	}
	
	public String forwardFootsteps(){
		request = ServletActionContext.getRequest();
		String content = request.getParameter("content");
		AccountHelper helper = AccountHelper.INSTANCE;
		if (helper.forwardByFootSteps(content))
			return null;
		return FAILURE;
	}
}
