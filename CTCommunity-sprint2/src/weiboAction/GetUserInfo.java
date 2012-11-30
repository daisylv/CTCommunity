package weiboAction;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import weibo4j.http.AccessToken;

import com.opensymphony.xwork2.ActionSupport;
import communityDB.AccountHelper;

	/**
	 * @author bjrara
	 * */

public class GetUserInfo extends ActionSupport {

	public static final String FAILURE = "failure";
	private HttpServletRequest request = ServletActionContext.getRequest();
	private static final long serialVersionUID = 1L;

	public String execute() {
		System.out.println("Come to get access Token");
		AccessToken accessToken = (AccessToken) ServletActionContext.getRequest().getSession().getAttribute("useraccessToken");
		System.out.println(accessToken.toString());
		weiboUtil util = new weiboUtil(accessToken);
		AccountHelper helper = AccountHelper.INSTANCE;
		helper.validation(accessToken);
		
		//System.out.println(util.getUid());
		//util.updateStatus("test");
		//util.sendProductInfoStatus();
		/*if (accessToken.getUid() == null)
			return "failure";*/
		return "success";
	}

}