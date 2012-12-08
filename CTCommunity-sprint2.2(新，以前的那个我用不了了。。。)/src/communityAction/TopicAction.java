package communityAction;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import communityDB.AccountHelper;

public class TopicAction extends ActionSupport {
	/**
	 * @author bjrara
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request = ServletActionContext.getRequest();
	public static final String FAILURE = "failure";
	
	public String execute() {
		String tpTitle = request.getParameter("tpTitle");
		String tpContent = request.getParameter("tpContent");
		AccountHelper helper = AccountHelper.INSTANCE;
		if(helper.saveTopic(tpTitle, tpContent))
			return SUCCESS;
		else
			return FAILURE;
	}
}