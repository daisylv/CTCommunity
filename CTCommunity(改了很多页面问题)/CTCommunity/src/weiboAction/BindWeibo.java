package weiboAction;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.User;

import com.opensymphony.xwork2.ActionSupport;
import communityDB.AccountHelper;
import communityDB.Weiboinfo;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
import weiboAction.Log;

/**
 * @author bjrara
 */

public class BindWeibo extends ActionSupport {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private User user;

	private static final long serialVersionUID = 1L;

	public String execute() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		String code = request.getParameter("code");
		if (code == null) {
			try {
				response.sendRedirect(new Oauth().authorize("code"));
			} catch (IOException | WeiboException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
		 * System.out.println(oauth.authorize("code"));
		 * System.out.print("Hit enter when it's done.[Enter]:"); BufferedReader
		 * br = new BufferedReader(new InputStreamReader(System.in)); }
		 */
		else {
			AccessToken accessToken = null;
			try {
				accessToken = new Oauth().getAccessTokenByCode(code);
				String userId = accessToken.getUid();
				weiboUtil util = new weiboUtil(accessToken);
				AccountHelper helper = AccountHelper.INSTANCE;
				Weiboinfo account = helper.validation(accessToken);
				user = helper.getUser();
				System.out.println(user);
				request.getSession().setAttribute("userid", account.getUserId());
				request.getSession().setAttribute("username", account.getWeiboName());
			} catch (WeiboException e) {
				if(401 == e.getStatusCode()){
					Log.logInfo("Unable to get the access token.");
				}else{
					e.printStackTrace();
				}
			}
			Log.logInfo("code: " + code);
		}
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}