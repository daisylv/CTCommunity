package weiboAction;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import weibo4j.Oauth;
import weibo4j.http.AccessToken;
import weibo4j.model.WeiboException;
import weiboAction.Log;

public class BindWeibo extends ActionSupport {

	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();

	private static final long serialVersionUID = 1L;

	public String execute() {
		String code = request.getParameter("code");
		if (code == null) {
			try {
				String s= null;
				s=new Oauth().authorize("code");
				System.out.println(s);
				response.sendRedirect(s);
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
				request.getSession().setAttribute("userId", userId);
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

}