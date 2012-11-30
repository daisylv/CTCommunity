package weiboAction;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

//import org.apache.struts2.ServletActionContext;
//import org.apache.struts2.interceptor.ServletRequestAware;

//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

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

	private static final long serialVersionUID = 1L;
	
	private String redirectUrl;
	
	public String  execute() {
		request=ServletActionContext.getRequest();
		response=ServletActionContext.getResponse();
		//System.out.println(request.toString());
		if(request  == null){
			System.out.println("requste null!");
		}
		System.out.println("Come into WeboAccess!");
		System.out.println(request.toString());
		String code = request.getParameter("code");
		System.out.println(code);
		if (code == null) {
			try {
				String s= null;
				s=new Oauth().authorize("code");
				System.out.println(s);
				setRedirectUrl(s);
				//response.sendRedirect(s);
				//return "success";
			} catch ( WeiboException e) {
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
				//String userId = accessToken.getUid();
				request.getSession().setAttribute("accessToken", accessToken);
				
			} catch (WeiboException e) {
				if(401 == e.getStatusCode()){
					Log.logInfo("Unable to get the access token.");
				}else{
					e.printStackTrace();
				}
			}
			Log.logInfo("code: " + code);
			//return null;
		}
		return "success";
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}


}